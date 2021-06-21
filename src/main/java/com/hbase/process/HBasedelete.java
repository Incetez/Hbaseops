package com.hbase.process;

import java.io.IOException;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.HBaseAdmin;

public class HBasedelete {

   public static void main(String[] args) throws IOException {

      Configuration conf = HBaseConfiguration.create();
      conf.set("hbase.master", "localhost:9000");
      conf.set("hbase.zookeeper.quorum","localhost");
      conf.set("hbase.zookeeper.property.clientPort", "2181");
      HBaseAdmin admin = new HBaseAdmin(conf);

      // disabling the table
      admin.disableTable("txns1");
      System.out.println("txns1 disabled");

      // deleting employee table
      admin.deleteTable("txns1");
      System.out.println("txns1 table is deleted");
   }
}