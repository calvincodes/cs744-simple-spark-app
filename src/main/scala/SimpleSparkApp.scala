import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

//TODO: Comment everything
object SimpleSparkApp {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("SimpleSparkApp")
    val sc = new SparkContext(conf)

    val inputLocation = args(0) // For testing use "hdfs://128.104.223.172:9000/input_2/part2_data.csv"
    val outputLocation = args(1) // For testing use "hdfs://128.104.223.172:9000/output_2/"

    val rawData = sc.textFile(inputLocation)

    //TODO: Ensure that the generated hash is presorted!
    val ccTimestampToLine
      = rawData.map(line => (line.split(",")(3).hashCode + line.split(",")(14), line))

    val sortedRdd = ccTimestampToLine.sortByKey()

    val resultRdd = sortedRdd.map(line => line._2)

    resultRdd.saveAsTextFile(outputLocation)

    sc.stop()
  }

}
