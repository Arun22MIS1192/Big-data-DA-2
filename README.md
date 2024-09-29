MovieLens Tag Clustering with Hadoop and SOM

This assignment processes the MovieLens dataset and applies a Self-Organizing Map (SOM) to cluster movies based on their tags using Hadoop MapReduce. The dataset includes movie tags provided by users, which are used to find patterns and group similar movies.

Dataset:
The dataset used in this project is the MovieLens Tags Dataset. It consists of user-provided tags for movies with the following fields:

userId: The unique ID of the user.
movieId: The unique ID of the movie.
tag: The user-provided tag associated with the movie.
timestamp: The time when the tag was assigned.

sample dataset:

![image](https://github.com/user-attachments/assets/6af0cb09-9b5c-493e-a5a5-0c828b3e69b5)


STEPS TO EXCUTE:


1. Upload Dataset to HDFS
Upload the MovieLens dataset (CSV file) to Hadoop’s HDFS. Replace /path/to/movielens.csv with the actual path of the dataset file.

bash hadoop fs -mkdir -p /movielens/input
hadoop fs -put /path/to/movielens.csv /movielens/input

2. Compile the Java Code
Compile the Java files using Hadoop’s classpath.

3. Run the Hadoop Job
Run the MapReduce job on the MovieLens dataset with the following command:
hadoop jar SOMMovieLens.jar SOMDriver /movielens/input /movielens/output

4.View the Output
Once the job completes, view the results of the SOM clustering:
bash hadoop fs -cat /movielens/output/part-r-00000

OUTPUT:

![image](https://github.com/user-attachments/assets/b34fe83a-453a-41ae-9f6e-c8b7c39f5c06)


Software Requirements:

JAVA 8 OR HIGHER

HADOOP

MOVIE LENS DATASET UPLOADED

Hardware Requirements:

Minimum:

Processor: Dual-core CPU

Memory: 4 GB RAM

Disk: 10 GB free space

OS: Linux/Mac/Windows


OUTPUTS:

Mapper:

![image](https://github.com/user-attachments/assets/0bc26e25-782f-4c4b-95b9-2d5a0c9b6e60)



Reducer:

![image](https://github.com/user-attachments/assets/a2d10d18-63d3-4e05-b962-8788e8932b48)


driver:

![image](https://github.com/user-attachments/assets/c798e06a-93dd-46b3-b0ac-bb6870f95b36)










