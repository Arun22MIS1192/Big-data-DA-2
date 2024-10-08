import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MovieLensReducer extends Reducer<Text, Text, Text, Text> {
    public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        StringBuilder ratings = new StringBuilder();

        for (Text val : values) {
            ratings.append(val.toString()).append(",");
        }

        context.write(key, new Text(ratings.toString()));
    }
}
