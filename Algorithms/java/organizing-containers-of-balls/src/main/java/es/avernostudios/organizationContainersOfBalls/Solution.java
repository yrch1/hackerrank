package es.avernostudios.organizationContainersOfBalls;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {


    public static List<Integer> ballsPerContainer(final List<List<Integer>> containers) {
        int containerCount = containers.size();
        int ballTypeCount = containers.get(0).size();
        List<Integer> ballsPerContainer = new ArrayList<>();

        for (int i = 0; i < ballTypeCount; i++) {
            int counter = 0;
            for (int j = 0; j < containerCount; j++) {
                counter += containers.get(j).get(i);
            }
            System.out.println(String.format("En el contenedor[%d]=%d", i, counter));
            ballsPerContainer.add(counter);
        }
        return ballsPerContainer;
    }

    public static List<Integer> ballsPerType(final List<List<Integer>> containers) {
        int containerCount = containers.size();
        int ballTypeCount = containers.get(0).size();
        List<Integer> ballsPerType = new ArrayList<>();

        for (int i = 0; i < containerCount; i++) {
            int counter = 0;
            for (int j = 0; j < ballTypeCount; j++) {
                counter += containers.get(i).get(j);
            }
            System.out.println(String.format("Del tipo[%d]=%d", i, counter));
            ballsPerType.add(counter);
        }
        return ballsPerType;
    }

    /*
     * Complete the 'organizingContainers' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts 2D_INTEGER_ARRAY container as parameter.
     */

    public static String organizingContainers(List<List<Integer>> containers) {
        // Write your code here
        int containerCount = containers.size();
        int ballTypeCount = containers.get(0).size();
        System.out.println(String.format("Hay %d contenedores y %d tipos de bolas"
                , containerCount, ballTypeCount));

        List<Integer> ballsPerContainer = ballsPerContainer(containers);
        List<Integer> ballsPerType = ballsPerType(containers);

        Collections.sort(ballsPerContainer);
        Collections.sort(ballsPerType);

        ballsPerContainer.stream().forEach((c) -> System.out.println(c + ","));
        System.out.println("---");
        ballsPerType.stream().forEach((c) -> System.out.println(c + ","));


        boolean isEqual = ballsPerContainer.equals(ballsPerType);      //false
        System.out.println(isEqual);

        String result;
        if (ballsPerContainer.equals(ballsPerType)) {
            result = "Possible";
        } else {
            result = "Impossible";
        }
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader;
        if (args.length > 0) {
            bufferedReader = new BufferedReader(new FileReader(args[0]));
        } else {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }


        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> container = new ArrayList<>();

                IntStream.range(0, n).forEach(i -> {
                    try {
                        container.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                String result = Result.organizingContainers(container);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}