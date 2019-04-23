package NEWPACK;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class MapReduce {
	String inDirPath, outDirPath;
	Job job;
	MapReduce(String inDirPath, String outDirPath) {
		this.inDirPath = inDirPath;
		this.outDirPath = outDirPath;

	}

	void doMapReduce() throws IOException, InterruptedException,
			ClassNotFoundException {

		Path inputPath = new Path(inDirPath);
		Path outputDir = new Path(outDirPath);

		// Create configuration
		Configuration conf = new Configuration(true);
		
		
		// Create job
		job = new Job(conf, "MapReduce.class");
		job.setJarByClass(Map.class);

		// Setup MapReduce
		
		job.setMapperClass(Map.class);
		job.setReducerClass(Reduce.class);
		
		
		job.setNumReduceTasks(1);

		// Specify key / value
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);

		// Input
		FileInputFormat.addInputPath(job, inputPath);
		job.setInputFormatClass(TextInputFormat.class);

		// Output
		FileOutputFormat.setOutputPath(job, outputDir);
		job.setOutputFormatClass(TextOutputFormat.class);

		// Delete output if exists
		FileSystem hdfs = FileSystem.get(conf);
		if (hdfs.exists(outputDir))
			hdfs.delete(outputDir, true);

		// Execute job
		int code = job.waitForCompletion(true) ? 0 : 1;
		// System.exit(code);
	}

	String getLogDetails() {
		String log = "";
		try {
			log = log + "Job ID = "+job.getJobID() + "\n";
			log = log + "Job Name = "+ job.getJobName().toString() + "\n";
			log = log + "Tracking URL "+ job.getTrackingURL().toString() + "\n";
			log = log + "Class = "+ job.getClass().toString() + "\n";
			log = log +"Map Progress = "+ job.mapProgress()+"\n";
			log = log +"Reduce Progress = "+ job.reduceProgress()+"\n";
			log = log +"Configuration = "+ job.getConfiguration().toString() + "\n";
			log = log +"Counters = "+ job.getCounters().toString() + "\n";
			
			

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return log;
	}
public static void main(String arg[]) throws Exception{
	MapReduce m=new MapReduce("D:\\VMStorage1\\veera", "D:\\VMStorage1\\veera\\output");
	m.doMapReduce();
	
}
}