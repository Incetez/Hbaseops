package com.hbase.process;
import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;

public class HBasescan {
	 public static void main(String args[]) throws IOException{

	      Configuration config = HBaseConfiguration.create();
	      HTable table = new HTable(config, "txns1");

	      // instantiate the Scan class
	      Scan scan = new Scan();

	      // scan the columns
	      scan.addColumn(Bytes.toBytes("cf1"), Bytes.toBytes("product"));
	      scan.addColumn(Bytes.toBytes("cf1"), Bytes.toBytes("amount"));

	      // get the ResultScanner
	      ResultScanner scanner = table.getScanner(scan);
	      for (Result result = scanner.next(); result != null; result=scanner.next())
	        System.out.println("Found row : " + result);

	      scanner.close();
	   }
}
