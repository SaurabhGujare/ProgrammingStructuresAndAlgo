package HW11Que7;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Saurabh Gujare
 * @NUID 001424874
 */
public class Main {
    private static Node first = new Node("first");
    private static Node second = new Node("second");
    private static Node third = new Node("third");
    private static Node fourth = new Node("fourth");
    private static Node fifth = new Node("fifth");
    private static ArrayList<Node> allNodes = new ArrayList<>();
    private static ArrayList<HW11_SaurabhGujare> betterChromosomes = new ArrayList<>();
    private static ArrayList<HW11_SaurabhGujare> possibleChromosomes = new ArrayList<>();
    private static ArrayList<HW11_SaurabhGujare> currentPopulation = new ArrayList<>();
    private static ArrayList<HW11_SaurabhGujare> mutatingChromosomes = new ArrayList<>();
    private static int evolutionCycleAmount = 1;
    private static int populationSize = 500;
    public static void main(String[] args) {
        allNodes.add(first);
        allNodes.add(second);
        allNodes.add(third);
        allNodes.add(fourth);
        allNodes.add(fifth);
        connectNodes(first, second, 7);
        connectNodes(first, third, 5);
        connectNodes(first, fourth, 3);
        connectNodes(first, fifth, 2);
        connectNodes(second, third, 6);
        connectNodes(second, fourth, 9);
        connectNodes(second, fifth, 8);
        connectNodes(third, fourth, 7);
        connectNodes(third, fifth, 11);
        connectNodes(fourth, fifth, 3);
        for (int i = 0; i < evolutionCycleAmount; i++) {
            fillCurrentPopulation(currentPopulation);
            sortPopulation(currentPopulation);
            for (int j = 1; j < currentPopulation.size(); j++) {
                possibleChromosomes.add(crossover(currentPopulation.get(j - 1), currentPopulation.get(j)));
            }
            sortPopulation(possibleChromosomes);
            betterChromosomes.addAll(currentPopulation);
            betterChromosomes.addAll(possibleChromosomes);
            currentPopulation.clear();
            possibleChromosomes.clear();
            for (HW11_SaurabhGujare chromosome :
                    betterChromosomes) {
                mutatingChromosomes.add(mutation(chromosome));
            }
            betterChromosomes.addAll(mutatingChromosomes);
            mutatingChromosomes.clear();
            sortPopulation(betterChromosomes);
        }
        for (HW11_SaurabhGujare chromosome :
                betterChromosomes) {
            System.out.println(chromosome.toString());
        }
    }
    private static HW11_SaurabhGujare crossover(HW11_SaurabhGujare chromosome1, HW11_SaurabhGujare chromosome2) {
        int rightBorder = new Random().nextInt(chromosome1.getNodes().size());
        while (rightBorder==0){
            rightBorder = new Random().nextInt(chromosome1.getNodes().size());
        }
        int leftBorder = new Random().nextInt(rightBorder);
        ArrayList<Node> sameNodes = new ArrayList<>();
        ArrayList<Integer> crossoverNodePositions = new ArrayList<>();

        for (int i = leftBorder; i < rightBorder; i++) {
            int chromosome2NodeIndex = chromosome2.getNodes().indexOf(chromosome1.getNodes().get(i));
            if (chromosome2NodeIndex > leftBorder && chromosome2NodeIndex < rightBorder) {
                sameNodes.add(chromosome1.getNodes().get(i));
                crossoverNodePositions.add(i);
            }
        }
        HW11_SaurabhGujare chromosome = new HW11_SaurabhGujare();
        for (int i = 0; i < chromosome1.getNodes().size(); i++) {
            if (!sameNodes.contains(chromosome1.getNodes().get(i))) {
                chromosome.addNode(chromosome1.getNodes().get(i));
            }
        }
        boolean[] taken = new boolean[sameNodes.size()];
        for (Integer crossoverNodePosition : crossoverNodePositions) {
            Node nodeToAdd;
            int nodeIndexToTake = new Random().nextInt(sameNodes.size());
            while (taken[nodeIndexToTake]) {
                nodeIndexToTake = new Random().nextInt(sameNodes.size());
            }
            taken[nodeIndexToTake] = true;
            nodeToAdd = sameNodes.get(nodeIndexToTake);
            chromosome.getNodes().add(crossoverNodePosition, nodeToAdd);
        }
        return chromosome;
    }
    private static void fillCurrentPopulation(ArrayList<HW11_SaurabhGujare> population) {
        for (int i = 0; i < populationSize; i++) {
            population.add(generateChromosome());
        }
    }
    private static void sortPopulation(ArrayList<HW11_SaurabhGujare> population) {
        population.sort((o1, o2) -> {
            if (o1.getDistance() == 0)
                o1.setDistance(calculateDistance(o1));
            if (o2.getDistance() == 0)
                o2.setDistance(calculateDistance(o2));
            return Integer.compare(o1.getDistance(), o2.getDistance());
        });
        while (population.size()>populationSize+1){
            population.remove(populationSize+1);
        }
    }
    private static int calculateDistance(HW11_SaurabhGujare chromosome) {
        int distance = 0;
        for (int i = 1; i < chromosome.getNodes().size(); i++) {
            Node pastNode = chromosome.getNodes().get(i - 1);
            Node thisNode = chromosome.getNodes().get(i);
            int indexOfPastNodeInAllNodes = allNodes.indexOf(pastNode);
            for (Pair<Node, Integer> pair :
                    allNodes.get(indexOfPastNodeInAllNodes).getConnections()) {
                if (thisNode == pair.getKey()) {
                    distance += pair.getValue();
                }
            } }
        return distance;
    }
    private static HW11_SaurabhGujare generateChromosome() {
        HW11_SaurabhGujare chromosome = new HW11_SaurabhGujare();
        boolean[] taken = new boolean[allNodes.size()];
        for (int i = 0; i < allNodes.size(); i++){
            int nextGeneToTake = new Random().nextInt(allNodes.size());
            while (taken[nextGeneToTake]) {
                nextGeneToTake = new Random().nextInt(allNodes.size());
            }
            chromosome.addNode(allNodes.get(nextGeneToTake));
            taken[nextGeneToTake] = true;
        }
        return chromosome;
    }
    private static HW11_SaurabhGujare mutation(HW11_SaurabhGujare chromosome) {
        return crossover(chromosome, chromosome);
    }
    private static void connectNodes(Node starting, Node ending, int weight) {
        starting.addNode(ending, weight);
        ending.addNode(starting, weight);
    }
}
