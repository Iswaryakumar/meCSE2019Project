package NEWPACK;

import java.io.IOException;
 

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
 
public class Reduce extends
        Reducer<Text, Void, Text, Text> {
 
    public void reduce(Text text, Iterable<DoubleWritable> values, Context context)
            throws IOException, InterruptedException {
        context.write(text, null);
    }
}