import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object SimpleSparkApp {

  def main(args: Array[String]): Unit = {

    // Get SparkContext
    val conf = new SparkConf().setAppName("SimpleSparkApp")
    val sc = new SparkContext(conf)

    // Fetch input and output file locations from input args
    val inputLocation = args(0)
    val outputLocation = args(1)

    // Read the data from input file into RDD
    val rawDataRdd = sc.textFile(inputLocation)

    // Step 1: Filter rows keeping only the rows which have actual data in them
    // Step 2: Split the content of each row using deliminiter ","
    // Store the result in filterArrayRdd -> each row is an array of strings
    val filterArrayRdd = rawDataRdd.filter(!_.startsWith("battery_level")).map(line => line.split(","))

    // Sort filterArrayRdd on 3rd and last column. Store result in sortedRdd
    val sortedRdd = filterArrayRdd.sortBy(r => (r(2), r(14)))

    // Convert each row of sortedRdd from Array[String] to String
    val resultRdd = sortedRdd.map(line => line.mkString(","))

    // Save resultRdd as a text file at user provided outputLocation
    resultRdd.saveAsTextFile(outputLocation)

    sc.stop()
  }
}
