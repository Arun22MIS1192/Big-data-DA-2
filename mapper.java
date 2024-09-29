import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class SOMMapper extends Mapper<LongWritable, Text, Text, double[]> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] fields = value.toString().split(",");
        if (fields.length == 4) {
            String movieId = fields[1];
            String tag = fields[2];

            double[] featureVector = convertTagToVector(tag);
            context.write(new Text(movieId), featureVector);
        }
    }

    private double[] convertTagToVector(String tag) {
        double[] vector = new double[10];
        switch (tag.toLowerCase()) {
            case "funny": vector[0] = 1.0; break;
            case "action": vector[1] = 1.0; break;
            case "drama": vector[2] = 1.0; break;
            default: break;
        }
        return vector;
    }
}
