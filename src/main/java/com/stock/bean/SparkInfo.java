package com.stock.bean;
import org.apache.spark.SparkConf;

public class SparkInfo {
	   private String master="local[*]";
	    private String appName="stock";
	    public String getMaster() {
			return master;
		}

		public void setMaster(String master) {
			this.master = master;
		}

		public String getAppName() {
			return appName;
		}

		public void setAppName(String appName) {
			this.appName = appName;
		}


		public String getExecutorMemory() {
			return executorMemory;
		}

		public void setExecutorMemory(String executorMemory) {
			this.executorMemory = executorMemory;
		}

	

		public String getDriverMemory() {
			return driverMemory;
		}

		public void setDriverMemory(String driverMemory) {
			this.driverMemory = driverMemory;
		}

		public String getDriverCore() {
			return driverCore;
		}

		public void setDriverCore(String driverCore) {
			this.driverCore = driverCore;
		}

		

		public String getDefaultParallelism() {
			return defaultParallelism;
		}

		public void setDefaultParallelism(String defaultParallelism) {
			this.defaultParallelism = defaultParallelism;
		}


		public String getApplicationMasterMemory() {
			return applicationMasterMemory;
		}

		public void setApplicationMasterMemory(String applicationMasterMemory) {
			this.applicationMasterMemory = applicationMasterMemory;
		}

		public String getApplicationMasterCore() {
			return applicationMasterCore;
		}

		public void setApplicationMasterCore(String applicationMasterCore) {
			this.applicationMasterCore = applicationMasterCore;
		}

		public String getDynamicAllocation() {
			return dynamicAllocation;
		}

		public void setDynamicAllocation(String dynamicAllocation) {
			this.dynamicAllocation = dynamicAllocation;
		}

		
	    private String executorMemory;
	   
 
	    private String driverMemory;
	    private String driverCore;
	
	    private String defaultParallelism;

	    private String applicationMasterMemory;
	    private String applicationMasterCore;
	    private String dynamicAllocation;
	 
	 
	    public SparkConf getSparkConfiguration() {
	        SparkConf sparkConf = new SparkConf();
	        
	        sparkConf.setMaster(getMaster());
	        sparkConf.setAppName(getAppName());
	        
	        if (getExecutorMemory() != null) {sparkConf.set("spark.executor.memory", getExecutorMemory());};
	       
	       
	        if (getDefaultParallelism() != null) {sparkConf.set("spark.default.parallelism", getDefaultParallelism());};
	      
	       
	        
	        
	        return sparkConf;
	    }
}