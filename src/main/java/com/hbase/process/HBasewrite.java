package com.hbase.process;

import java.io.*;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

public class HBasewrite {
	
	public static void main(String[] args) throws IOException
	{
		// instantiate Configuration class
	      Configuration config = HBaseConfiguration.create();

	      // instantiate HTable class
	      HTable hTable = new HTable(config, "txns1");

	      File file = new File("/home/hduser/hive/data/txns"); 
	      
	    
		BufferedReader br = new BufferedReader(new FileReader(file)); 
	      
	      String st; 
	      while ((st = br.readLine()) != null) 
	      {  
	      String[] str = st.split(",");
	      // instantiate Put class
	      Put p = new Put(Bytes.toBytes(str[0])); 

	      // add values using add() method
	      p.add(Bytes.toBytes("cf1"),Bytes.toBytes("txndate"),Bytes.toBytes(str[1]));
	      p.add(Bytes.toBytes("cf1"),Bytes.toBytes("txncustid"),Bytes.toBytes(str[2]));
	      p.add(Bytes.toBytes("cf1"),Bytes.toBytes("amount"),Bytes.toBytes(str[3]));
	      p.add(Bytes.toBytes("cf1"),Bytes.toBytes("category"),Bytes.toBytes(str[4]));
	      p.add(Bytes.toBytes("cf1"),Bytes.toBytes("product"),Bytes.toBytes(str[5]));
	      p.add(Bytes.toBytes("cf1"),Bytes.toBytes("city"),Bytes.toBytes(str[6]));
	      p.add(Bytes.toBytes("cf1"),Bytes.toBytes("state"),Bytes.toBytes(str[7]));
	      p.add(Bytes.toBytes("cf1"),Bytes.toBytes("paymenttype"),Bytes.toBytes(str[8]));
		    
	      // save the put Instance to the HTable.
	      hTable.put(p);
	      }
	      System.out.println("data inserted successfully");
	      // close HTable instance
	      hTable.close();
	     
	   }
	}


