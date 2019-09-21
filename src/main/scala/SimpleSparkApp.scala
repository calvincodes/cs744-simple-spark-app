import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object SimpleSparkApp {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Simple App")
    val sc = new SparkContext(conf)

    val fileLocation = "hdfs://128.104.223.172:9000/users/ajain/hdfs/part2_data.csv"
    val rawFile = sc.textFile(fileLocation)
    rawFile.map(s => s.length).reduce((a, b) => a + b)
  }

}
