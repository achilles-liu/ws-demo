package org.ws.core.structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ws.core.structure.TTree.Factory;
import org.ws.core.structure.TTree.Node;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * test tree
 * @author Achilles Liu
 *
 */
public class Test {
	
	static List<Map<String,Object>> datas = new ArrayList<Map<String,Object>>();
	static List<Map<String,Object>> datas2 = new ArrayList<Map<String,Object>>();
	static{
		Map<String,Object> m0 = new HashMap<String,Object>();
		m0.put("id", 0);
		m0.put("pid", -1);
		m0.put("name", "root");
		m0.put("alias", "root");
		Map<String,Object> m1 = new HashMap<String,Object>();
		m1.put("id", 1);
		m1.put("pid", 0);
		m1.put("name", "node1");
		m1.put("alias", "alias1");
		Map<String,Object> m2 = new HashMap<String,Object>();
		m2.put("id", 2);
		m2.put("pid", 0);
		m2.put("name", "node2");
		m2.put("alias", "alias2");
		Map<String,Object> m3 = new HashMap<String,Object>();
		m3.put("id", 3);
		m3.put("pid", 1);
		m3.put("name", "node11");
		m3.put("alias", "alias11");
		Map<String,Object> m4 = new HashMap<String,Object>();
		m4.put("id", 4);
		m4.put("pid", 1);
		m4.put("name", "node12");
		m4.put("alias", "alias12");
		Map<String,Object> m5 = new HashMap<String,Object>();
		m5.put("id", 5);
		m5.put("pid", 2);
		m5.put("name", "node21");
		m5.put("alias", "alias21");
		Map<String,Object> m6 = new HashMap<String,Object>();
		m6.put("id", 6);
		m6.put("pid", 2);
		m6.put("name", "node22");
		m6.put("alias", "alias22");
		
		Map<String,Object> m7 = new HashMap<String,Object>();
		m7.put("id", 7);
		m7.put("pid", 3);
		m7.put("name", "node111");
		m7.put("alias", "alias111");
		Map<String,Object> m8 = new HashMap<String,Object>();
		m8.put("id", 8);
		m8.put("pid", 3);
		m8.put("name", "node112");
		m8.put("alias", "alias112");
		
		Map<String,Object> m9 = new HashMap<String,Object>();
		m9.put("id", 9);
		m9.put("pid", 7);
		m9.put("name", "node1111");
		m9.put("alias", "alias1111");
		
		datas.add(m8);
		datas.add(m9);
		datas.add(m7);
		datas.add(m4);
		datas.add(m2);
		datas.add(m3);
		datas.add(m6);
		datas.add(m5);
		datas.add(m1);
		datas.add(m0);
		
		datas2.add(m7);
		datas2.add(m4);
		datas2.add(m2);
		datas2.add(m8);
		datas2.add(m3);
		datas2.add(m9);
		datas2.add(m6);
		datas2.add(m5);
		datas2.add(m1);
		//datas2.add(m0);
	}
	
	public static class UserNode extends Node{
		private String name;
		private String alias;
		
		public UserNode(){}
		
		public UserNode(int id,int pid,String name,String alias){
			super(id,pid);
			this.name = name;
			this.alias = alias;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAlias() {
			return alias;
		}
		public void setAlias(String alias) {
			this.alias = alias;
		}
	}

	public static void main(String[] args) throws Exception {
		TTree<UserNode> tree = new TTree<UserNode>(datas,new Factory<UserNode>(){
			public UserNode create(Map<String, Object> item) {
				UserNode un = new UserNode();
				un.setId(Integer.valueOf(String.valueOf(item.get("id"))));
				un.setPid(Integer.valueOf(String.valueOf(item.get("pid"))));
				un.setName(String.valueOf(item.get("name")));
				un.setAlias(String.valueOf(item.get("alias")));
				return un;
			}});
		/*TTree<UserNode> tree2 = new TTree<UserNode>(datas2,new Factory<UserNode>(){
			public UserNode create(Map<String, Object> item) {
				UserNode un = new UserNode();
				un.setId(Integer.valueOf(String.valueOf(item.get("id"))));
				un.setPid(Integer.valueOf(String.valueOf(item.get("pid"))));
				un.setName(String.valueOf(item.get("name")));
				un.setAlias(String.valueOf(item.get("alias")));
				return un;
			}},false,new UserNode(0,-1,"root2","root2"));*/
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(tree));
		//System.out.println(mapper.writeValueAsString(tree.getRoot()));
		
		//System.out.println(mapper.writeValueAsString(tree2));
		//System.out.println(mapper.writeValueAsString(tree2.getRoot()));
	}

}
