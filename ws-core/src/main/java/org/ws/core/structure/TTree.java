package org.ws.core.structure;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ws.core.structure.TTree.Node;

/**
 * tree
 * @author Achilles Liu
 *
 * @param <T>
 */
public class TTree<T extends Node>{
	
	/**
	 * the root of tree.
	 */
	private T root;
	/**
	 * the factory to create the node.
	 */
	private Factory<T> factory;
	
	/**
	 * indicate whether the root node data is existing into the data collection.
	 * true means the root data exists into the data collection.
	 * if false without root node, the default method that create the root node will be called.
	 * if false with root node, the root will be the specified root node.
	 */
	private boolean hasRootData = true;
	
	public TTree(List<Map<String,Object>> data,Factory<T> factory){
		this(data,factory,true);
	}
	
	public TTree(List<Map<String, Object>> data,Factory<T> factory,boolean hasRootData){
		this(data,factory,hasRootData,null);
	}
	
	public TTree(List<Map<String,Object>> data,Factory<T> factory,boolean hasRootData,T root){
		this.factory = factory;
		this.root = root;
		this.hasRootData = hasRootData;
		assemble(data);
	}
	
	/**
	 * the default method, which create the root.
	 * if the data of root doesn't input,this method will be called.
	 * @return
	 */
	private T createRoot(){
		Map<String, Object> dt = new HashMap<String, Object>();
		dt.put("id", 0);
		dt.put("pid", -1);
		return factory.create(dt);
	}
	
	/**
	 * assemble the tree using the inputed data.
	 * @param data
	 */
	private void assemble(List<Map<String, Object>> data){
		
		if(this.hasRootData && this.root==null){
			Map<String,Object> rd = findRoot(data);
			
			if(rd == null) throw new IllegalArgumentException("illegal argument: [ hasRootData ]");
			this.root = factory.create(rd);
		}else{
			if(this.root == null)this.root = createRoot();
		}
		
		T tnode = null;
		List<Map<String,Object>> orphan = null;
		for(Map<String, Object> item:data){
			tnode = factory.create(item);
			int pid = tnode.getPid();
			if(pid == -1) {
				continue;
			}
			T parent = findParentByPid(root,pid);
			if(parent != null){
				parent.getChildren().add(tnode);
			}else{
				if(orphan == null){
					orphan = new ArrayList<Map<String,Object>>();
				}
				orphan.add(item);
			}
		}
		
		if(orphan != null){
			assemble(orphan);
		}
	}
	
	/**
	 * check whether or not the data of root is existing in the inputed collections.
	 * if existing, the data will be used to create a new root node.
	 * @param data
	 * @return
	 */
	private Map<String, Object> findRoot(List<Map<String,Object>> data){
		Map<String, Object> rootData = null;
		for(Map<String, Object> dt : data){
			int pid = Integer.valueOf(String.valueOf(dt.get("pid")));
			if(pid == -1){
				rootData = dt;
				break;
			}
		}
		return rootData;
	}
	
	/**
	 * find the parent node according to the specified pid.
	 * @param node
	 * @param pid
	 * @return
	 */
	private T findParentByPid(T node,int pid){
		if(node.getId() == pid){
			return node;
		}else{
			@SuppressWarnings("unchecked")
			List<T> children = (List<T>) node.getChildren();
			T parent = null;
			for(T item : children){
				parent = findParentByPid(item,pid);
				if(parent != null) break;
			}
			return parent;
		}
	}
	
	public T getRoot(){
		return this.root;
	}
	
	/**
	 * the factory to create the node.
	 * the factory will be used to create this node,
	 * Map<String, Object> datas = ...
	 * TTree<UserNode> tree = new TTree<UserNode>(datas,new Factory<UserNode>(){
	 *		public UserNode create(Map<String, Object> item) {
	 *			UserNode userNode = new UserNode();
	 *			userNode.setId(Integer.valueOf(String.valueOf(item.get("id"))));
	 *			userNode.setPid(Integer.valueOf(String.valueOf(item.get("pid"))));
	 *			userNode.setName(String.valueOf(item.get("name")));
	 *			userNode.setAlias(String.valueOf(item.get("alias")));
	 *			return userNode;
	 *  }});
	 * @author Achilles Liu
	 *
	 * @param <T>
	 */
	public interface Factory<T extends Node> {
		T create(Map<String,Object> item);
	}
	
	/**
	 * the top class of node.
	 * it can be implemented to customize the specified node.
	 * for example, the "UserNode" node can be customized as follows,
	 * public class UserNode extends Node{
	 *	private String name;
	 *	private String alias;
	 *  ...
	 *	public String getName() {
	 *		return name;
	 *	}
	 *	public void setName(String name) {
	 *		this.name = name;
	 *	}
	 *	public String getAlias() {
	 *		return alias;
	 *	}
	 *	public void setAlias(String alias) {
	 *		this.alias = alias;
	 *	}
	 *  ...
	 * }
	 * @author Achilles Liu
	 *
	 */
	public static class Node implements Comparator<Node>{
		/**
		 * id
		 */
		private int id;
		/**
		 * parent id
		 */
		private int pid;
		/**
		 * children of the node
		 */
		private List<Node> children = new ArrayList<Node>();
		
		public Node(){}
		
		public Node(int id, int pid){
			this.id = id;
			this.pid = pid;
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		
		public int getPid() {
			return pid;
		}
		public void setPid(int pid) {
			this.pid = pid;
		}
		public List<Node> getChildren() {
			return children;
		}
		
		public void setChildren(List<Node> children) {
			this.children = children;
		}

		public int compare(Node o1, Node o2) {
			return o1.getId()-o2.getId();
		}
	}
}
