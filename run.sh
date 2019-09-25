echo 'Running command: "sbt package"'
echo ""
sbt package

echo ""
echo 'Enter input file path:'
echo '(Format: hdfs://10.10.1.1:9000/input/file/path)'
read -r input_file_path

echo ""
echo 'Enter output file path (Overwriting not allowed):'
echo '(Format: hdfs://10.10.1.1:9000/output/file/path)'
read -r output_file_path

echo ""
echo 'Submitting spark job'
echo ""
spark-submit \
  --class "SimpleSparkApp" \
  target/scala-2.11/cs744-simple-spark-app_2.11-0.1.jar \
  "$input_file_path" \
  "$output_file_path"