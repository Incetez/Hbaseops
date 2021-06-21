package com.hbase.process;

import java.io.IOException;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.conf.Configuration;

public class HBasecreate {

	public static void main(String[] args) throws IOException {

		Configuration conf = HBaseConfiguration.create();

		// instantiating HbaseAdmin class by passing on configuration class
		
		HBaseAdmin admin = new HBaseAdmin(conf);

		HTableDescriptor tableDescriptor = new HTableDescriptor(TableName.valueOf("txns1"));

		// adding column families to table descriptor
		tableDescriptor.addFamily(new HColumnDescriptor("cf1"));
		//tableDescriptor.addFamily(new HColumnDescriptor("cf2"));
		//tableDescriptor.addFamily(new HColumnDescriptor("cf3"));
		
		// creating the table
		admin.createTable(tableDescriptor);
		System.out.println(" Table created ");
	}
}