echo 'Running command: "sbt package"'
echo ""
sbt package

echo ""
echo 'Submitting spark job'
echo ""
spark-submit \
  --class "SimpleSparkApp" \
  target/scala-2.11/cs744-simple-spark-app_2.11-0.1.jar \
  "$1" \
  "$2"