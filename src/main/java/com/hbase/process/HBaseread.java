package com.hbase.process;
import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

public class HBaseread {

	public static void main(String[] args) throws IOException, Exception{
		   
	      Configuration config = HBaseConfiguration.create();
	      HTable table = new HTable(config, "txns");

	      // instantiate Get class
	      Get g = new Get(Bytes.toBytes("00065133"));

	      // get the Result object
	      Result result = table.get(g);

	      // read values from Result class object
	      byte [] txndate = result.getValue(Bytes.toBytes("cf1"),Bytes.toBytes("txndate"));
	      byte [] txncustid = result.getValue(Bytes.toBytes("cf1"),Bytes.toBytes("txncustid"));
	      byte [] amount = result.getValue(Bytes.toBytes("cf1"),Bytes.toBytes("amount"));
	      byte [] category = result.getValue(Bytes.toBytes("cf1"),Bytes.toBytes("category"));
	      byte [] product = result.getValue(Bytes.toBytes("cf1"),Bytes.toBytes("product"));
	      byte [] city = result.getValue(Bytes.toBytes("cf1"),Bytes.toBytes("city"));
	      byte [] state = result.getValue(Bytes.toBytes("cf1"),Bytes.toBytes("state"));
	      byte [] paymenttype = result.getValue(Bytes.toBytes("cf1"),Bytes.toBytes("paymenttype"));
	      
	      System.out.println("txndate: " + Bytes.toString(txndate));
	      System.out.println("txncustid: " + Bytes.toString(txncustid));
	      System.out.println("amount: " + Bytes.toString(amount));
	      System.out.println("category: " + Bytes.toString(category));
	      System.out.println("product: " + Bytes.toString(product));
	      System.out.println("city: " + Bytes.toString(city));
	      System.out.println("state: " + Bytes.toString(state));
	      System.out.println("paymenttype: " + Bytes.toString(paymenttype));
	   }
}
