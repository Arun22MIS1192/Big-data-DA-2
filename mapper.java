import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class SOMMapper extends Mapper<Object, Text, IntWritable, Text> {
    private IntWritable movieId = new IntWritable();

    @Override
    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        String[] fields = value.toString().split(",");
        
        int id = Integer.parseInt(fields[1]); 
        String tag = fields[2];
        movieId.set(id);
        context.write(movieId, new Text(tag));
    }
}