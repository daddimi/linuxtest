package com.hive;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ChartController {

	String url = "jdbc:hive2://192.168.111.130:10000/default";
	String userid = "root";
	String password = "111111";
	
	public ChartController() {
		try {
			Class.forName("org.apache.hive.jdbc.HiveDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/getdata1.mc")
	@ResponseBody
	public void getdata1(HttpServletResponse res) throws Exception {
		
		Connection con = null ;
		JSONArray ja = new JSONArray();
		try {
			con = DriverManager.getConnection(url, userid, password);
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM SubwayPassenger limit 10");
			ResultSet rset = pstmt.executeQuery();
			
			// [{name: 'Sweden',data:[]},{}]
			
			while(rset.next()) {
				JSONObject jo = new JSONObject();
				jo.put("name", rset.getString(2));
				JSONArray jo2 = new JSONArray();
				jo2.add(rset.getFloat(3));
				jo2.add(rset.getFloat(4));
				jo2.add(rset.getFloat(5));
				jo.put("data", jo2);
				ja.add(jo);
			}
		} catch(Exception e) {
			throw e;
		} finally {
			con.close();
		}
		  res.setCharacterEncoding("EUC-KR");
	        res.setContentType("application/json");
	        PrintWriter out = res.getWriter();
	        out.print(ja.toJSONString());
	        out.close();
		
		
	}
		
		
		@RequestMapping("/getdata2.mc")
		@ResponseBody
		public void getdata2(HttpServletResponse res) throws Exception {
			
			Connection con2 = null ;
			JSONArray ja2 = new JSONArray();
			try {
				con2 = DriverManager.getConnection(url, userid, password);
				PreparedStatement pstmt = con2.prepareStatement("SELECT * FROM SubwayPassenger limit 10");
				ResultSet rset = pstmt.executeQuery();
				
				// [{name: 'Sweden',data:[]},{}]
				
				while(rset.next()) {
					JSONObject job = new JSONObject();
					job.put("name", rset.getString(3));
					JSONArray job2 = new JSONArray();
					job2.add(rset.getFloat(4));
					job2.add(rset.getFloat(5));
					job.put("data", job2);
					ja2.add(job);
				}
			} catch(Exception e) {
				throw e;
			} finally {
				con2.close();
			}
		
	        res.setCharacterEncoding("EUC-KR");
	        res.setContentType("application/json");
	        PrintWriter out = res.getWriter();
	        out.print(ja2.toJSONString());
	        out.close();
	}
		
		
		@RequestMapping("/getdata3.mc")
		@ResponseBody
		public void getdata3(HttpServletResponse res) throws Exception {
			
			Connection con3 = null ;
			JSONArray ja3 = new JSONArray();
			try {
				con3 = DriverManager.getConnection(url, userid, password);
				PreparedStatement pstmt = con3.prepareStatement("SELECT * FROM SubwayPassenger limit 10");
				ResultSet rset = pstmt.executeQuery();
				
				// [{name: 'Sweden',data:[]},{}]
				
				while(rset.next()) {
					JSONObject jt = new JSONObject();
					jt.put("name", rset.getInt(4));
					
					JSONArray job3 = new JSONArray();
					job3.add(rset.getInt(5));
					jt.put("data", job3);
					ja3.add(jt);
				}
			} catch(Exception e) {
				throw e;
			} finally {
				con3.close();
			}
		
	        res.setCharacterEncoding("EUC-KR");
	        res.setContentType("application/json");
	        PrintWriter out = res.getWriter();
	        out.print(ja3.toJSONString());
	        out.close();
	}
	
		
		
		@RequestMapping("/getdata4.mc")
		@ResponseBody
		public void getdata4(HttpServletResponse res) throws Exception {
			
			Connection con4 = null ;
			JSONArray ja4 = new JSONArray();
			try {
				con4 = DriverManager.getConnection(url, userid, password);
				PreparedStatement pstmt = con4.prepareStatement("SELECT * FROM SubwayPassenger limit 10");
				ResultSet rset = pstmt.executeQuery();
				
				// [{name: 'Sweden',data:[]},{}]
				
				while(rset.next()) {
					JSONObject jc = new JSONObject();
					jc.put("name", rset.getInt(4)+"È£¼±");
					JSONArray job4 = new JSONArray();
				
					job4.add(rset.getInt(5));
					jc.put("y", rset.getInt(5));
					ja4.add(jc);
				}
			} catch(Exception e) {
				throw e;
			} finally {
				con4.close();
			}
		
	        res.setCharacterEncoding("EUC-KR");
	        res.setContentType("application/json");
	        PrintWriter out = res.getWriter();
	        out.print(ja4.toJSONString());
	        out.close();
	}
	
}
