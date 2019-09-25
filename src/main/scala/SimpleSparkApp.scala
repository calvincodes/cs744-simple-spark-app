import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

//TODO: Comment everything
object SimpleSparkApp {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("SimpleSparkApp")
    val sc = new SparkContext(conf)

    val inputLocation = args(0) // For testing use "hdfs://10.10.1.1:9000/input_2/part2_data.csv"
    val outputLocation = args(1) // For testing use "hdfs://10.10.1.1:9000/output_2/"

    val rawData = sc.textFile(inputLocation)

    val filteredRdd = rawData.filter(!_.startsWith("battery_level")).map(line => line.split(","))
    val sortedRdd = filteredRdd.sortBy(r => (r(2), r(14)))

    val resultRdd = sortedRdd.map(line => line.mkString(","))

    resultRdd.saveAsTextFile(outputLocation)

    sc.stop()
  }

}
