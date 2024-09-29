import java.io.IOException;
import java.util.HashMap;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class SOMReducer extends Reducer<IntWritable, Text, IntWritable, Text> {
    
    public void reduce(IntWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        HashMap<String, Integer> tagFrequency = new HashMap<>();
        for (Text val : values) {
            String tag = val.toString();
            tagFrequency.put(tag, tagFrequency.getOrDefault(tag, 0) + 1);
        }
 
        StringBuilder sb = new StringBuilder();
        for (String tag : tagFrequency.keySet()) {
            sb.append(tag).append(":").append(tagFrequency.get(tag)).append(", ");
        }
        
        context.write(key, new Text(sb.toString()));
    }
}
