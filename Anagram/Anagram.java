import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// This class takes a word and allows for checking if lists of words contain anagrams matching the word stored in the class.

public class Anagram {

    private List<Character> myLetters;
    private String myWord;

    // Predicate that takes a String and checks whether or not it's an anagram of myWord
    Predicate<String> isAnagram = word ->  {
        List<Character> characters = new ArrayList<>();
        if(word.toLowerCase().equals(this.myWord)){
            return false;
        }
        word.toLowerCase().chars().sorted().forEach(c -> characters.add((char) c));
        if(characters.size() != myLetters.size()){
            return false;
        }
        for(int i = 0; i < characters.size(); i++){
            if(characters.get(i) != myLetters.get(i)){
                return false;
            }
        }
        return true;
    };

    public Anagram(String myWord){
        this.myWord = myWord.toLowerCase();
        myLetters = new ArrayList<>();
        this.myWord.chars()
                .sorted()
                .forEach(c -> myLetters.add((char) c));
    }

    // Returns a List of Strings that can be anagrams of myWord
    public List<String> match(List<String> listOfWords){
        return listOfWords.stream().filter(isAnagram).collect(Collectors.toList());
    }



}
