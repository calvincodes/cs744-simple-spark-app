import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object SimpleSparkApp {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Simple App")
    val sc = new SparkContext(conf)

    //TODO: Both of these will be passed by the caller
    val inputLocation = "hdfs://128.104.223.172:9000/users/ajain/hdfs/input/part2_data.csv"
    val outputLocation = "hdfs://128.104.223.172:9000/users/ajain/hdfs/output/"

    val rawData = sc.textFile(inputLocation)

    val ccTimestampToLine
      = rawData.map(line => (line.split(",")(3).hashCode + line.split(",")(14), line))

    val sortedRdd = ccTimestampToLine.sortByKey()

    val resultRdd = sortedRdd.map(line => line._2)

    resultRdd.saveAsTextFile(outputLocation)
  }

}
