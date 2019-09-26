# Simple Spark App

### Prerequisites

* scala-2.11.6
* sbt-1.3.2
* Java-1.8 (assuming available)
* HDFS-3.1.2 (assuming available)
* Spark-2.4.4 (assuming available)

### Installing

#### Installing scala
```
sudo apt-get update
sudo apt-get install scala
```

#### Installing sbt
```
echo "deb https://dl.bintray.com/sbt/debian /" | sudo tee -a /etc/apt/sources.list.d/sbt.list
curl -sL "https://keyserver.ubuntu.com/pks/lookup?op=get&search=0x2EE0EA64E40A89B84B2DF73499E82A75642AC823" | sudo apt-key add
sudo apt-get update
sudo apt-get install sbt
```

## Running the application

```sh run.sh```

This will ask you to provide `input_file_path` and `output_file_path`. You can have them on HDFS or local FS.

## Authors

* **[Anshu Verma](https://github.com/anshuv99)**
* **[Arpit Jain](https://github.com/calvincodes)**
* **[Arun Jose](https://github.com/arun123jose)**

