package NEWPACK;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import csvreader.CSVParser;
import csvreader.CSVWriter;

public class Map extends Mapper<Object, Text, Text, Text> {

	private DoubleWritable ONE = new DoubleWritable();
	private Text word = new Text();

	public void map(Object key, Text value, Context context)
			throws IOException, InterruptedException {
		CSVParser parser = new CSVParser(CSVParser.DEFAULT_SEPARATOR,
				CSVParser.DEFAULT_QUOTE_CHARACTER,
				CSVParser.DEFAULT_ESCAPE_CHARACTER);
		String[] ar = parser.parseLineMulti(value.toString());
		CSVWriter writer = new CSVWriter(new FileWriter(new File("a.txt")));
        String[] ar1 = new String[ar.length];
        ar1[0] = ar[0];
        ar1[1] = ar[1];
        ar1[2] = ar[2];
        ar1[3] = ar[3];
        ar1[4] = ar[4];
        ar1[5] = ar[5];
        ar1[6] = ar[6];
        ar1[7] = ar[7];
        ar1[8] = ar[8];
        ar1[9] = ar[9];
        ar1[10] = ar[10];
        ar1[11] = ar[11];
		String line = writer.getNext(ar);
		word = new Text(line);
		context.write(word, new Text(""));
	}
    String getRange(String s) {
        int n = new Integer(s).intValue();
        String x = "null";
        if (n <= 15) {
            x = "0-15";
        } else if (n <= 25 && n > 15) {
            x = "16-25";
        } else if (n > 25 && n <= 35) {
            x = "26-35";
        } else if (n > 35 && n <= 45) {
            x = "36-45";
        } else if (n > 45 && n <= 55) {
            x = "46-55";
        } else if (n > 55 && n <= 65) {
            x = "56-65";
        } else if (n > 65 && n <= 75) {
            x = "66-75";
        } else if (n > 75 && n <= 85) {
            x = "76-85";
        } else if (n > 85 && n <= 95) {
            x = "86-95";
        } else {
            x = "86-100";
        }

        return x;

    }
    String getStringWithLengthAndFilledWithCharacter(String t) {
        int p = t.length() / 2;
        String s = "";
        for (int i = 0; i < t.length(); i++) {
            if (i < p) {
                s = s + t.charAt(i);
            } else {
                s = s + "*";
            }
        }
        return s;
    }
	String getLevel(String t) {
		String s = "";
		int n = Integer.parseInt(t.trim()) / 1000;
		if (n < 20) {
			s = "0-20000";
		} else if (n >= 20 && n <= 40) {
			s = "10000-20000";
		} else if (n >= 40 && n <= 60) {
			s = "40000-60000";
		} else if (n >= 60 && n <= 80) {
			s = "40000-80000";
		} else if (n >= 80 && n <= 100) {
			s = "80000-100000";
		} else if (n >= 100 && n <= 150) {
			s = "100000-150000";
		} else if (n >= 150 && n <= 200) {
			s = "150000-200000";
		} else {
			s = "200000<";
		}
		return s;
	}

	String getLevelDue(String t) {
		String s = "";
		double n = Double.parseDouble(t.trim());
		if (n < 20) {
			s = "0-20";
		} else if (n >= 20 && n <= 20) {
			s = "10-20";
		} else if (n >= 40 && n <= 60) {
			s = "40-60";
		} else if (n >= 60 && n <= 80) {
			s = "40-80";
		} else if (n >= 80 && n <= 100) {
			s = "80-100";
		} else if (n >= 100 && n <= 150) {
			s = "100-150";
		} else if (n >= 150 && n <= 200) {
			s = "150-200";
		} else {
			s = "200<";
		}
		return s;
	}

}