//Name: Ishaan Mittal 
//Date: 11-04-2024
//Assignment: Calculator 
//Purpose: To Create a calculator appllication 
package calculator;

import java.util.Scanner; //imporing scanner for user input

//External Sources used: 
//For secondIndex: https://www.baeldung.com/java-locate-nth-match-substring#:~:text=Therefore%2C%20a%20straightforward%20idea%20to,(substring%2C%20firstIdx%20%2B%20substring.
//System.Exit(): https://www.baeldung.com/java-system-exit
//Removing space from input: https://www.baeldung.com/java-string-remove-whitespace
//Math.Floor(): https://www.w3resource.com/javascript-exercises/javascript-math-exercise-38.php#google_vignette
//Basic mechanism of the code:
//Essentially the code takes the number before and after the sign and saves it into a list that is respective to the sign used
//After this, based on the sign the calcultions is done and as the user can only enter up to 3 terms the 3rd number is located thourgh the use of substrings 
//The if statments are also structured in the form of bedmas so the operations such as exponents or multiplication is done before addition or subtraction 
//In addition, the for loop runs left to right again to respect the rules of Bedmas is if it is the same operation you would go left to right 
public class Calculator {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in); //creats a scanner for user input
        String equation;

        System.out.println("\t \t \t \t \t \t \t \t \t \t WELCOME TO THE CALCULATOR PROGRAM!");
        System.out.println("\n" + "NOTE: When entering an experssion with square root it can only be two terms (e.g. sqrt 36 + 3)"); //informing user about the square root rule
        System.out.println("Please enter your 2 or 3 term equation");  //informing user that the calculator will accept 3 term equations 

        System.out.print("\n" + "Equation: "); //asking for the equation
        equation = myScanner.nextLine(); //extracting the user input and saving it into the equation varaible 

        equation = equation.replaceAll("\\s", ""); //removing spaces from the input
        equation = equation.toLowerCase(); //converting the input into lowercase to make it easier when trying to find the sqrt term 

        char[] input = equation.toCharArray(); //converts the input into a char array so each indivudal elemnt can be analysed 
        String[] add = new String[10]; //declaring lists for the operation 
        String[] sub = new String[10];
        String[] expo = new String[10];
        String[] sqrt = new String[10];
        String[] multi = new String[10];
        String[] divide = new String[10];

        String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};

        String otherNum;

        boolean first = false; //declaring varibles that help with the input extraction process
        boolean first2 = false;
        boolean first3 = false;
        boolean first4 = false;
        boolean first5 = false;
        boolean last = false;
        boolean last2 = false;
        boolean last3 = false;
        boolean last4 = false;
        boolean last5 = false;
        boolean last6 = false;
        double answer = 0;
        String numAnswer;

        boolean check = true;
        boolean check2 = true;
        boolean check3 = true;
        boolean check4 = true;
        boolean check5 = true;
        boolean check6 = true;
        boolean check7 = true;
        boolean check8 = true;

        int counter = 0; //these varibales are for the index of the list 
        int counter2 = 0;
        int counter3 = 0;
        int counter4 = 0;
        int counter5 = 0;
        int counter6 = 0;

        int secondIndex = equation.indexOf("x", equation.indexOf("x") + "x".length()); //This is used to find the second index of the signs mentioned, it is done for only these 4 as it is illogical to have it for sqrt and exponents 
        int secondIndex2 = equation.indexOf("/", equation.indexOf("/") + "/".length());
        int secondIndex3 = equation.indexOf("+", equation.indexOf("+") + "+".length());
        int secondIndex4 = equation.indexOf("-", equation.indexOf("-") + "-".length());

        //substring first index is inslucive while the other is not inclusvie 
        for (int i = 0; i < input.length; i++) { //loops thourgh every element in the char array 
            if (input[i] == '^' || input[i] == 's') { //checks if the elemnt is either exponent or the square root (Note: it says s as it is going left to right) 
                if (input[i] == '^') { //checks for exponent 

                    for (int j = equation.indexOf(input[i]); j > 0; j--) { //going backwards from the exponent to extra the first number or the number the exponent is applied to 
                        if (input[j] == 't') { //checks if there is a sqrt before the exponent so the input can be saved properly without this it would just save eveyrthing before the exponent which is incorrect
                            expo[counter] = equation.substring(equation.indexOf(input[j]) + 1, equation.indexOf("^")); //saves the number into the exponent list, notice the first parameter says + 1 becuase it is inclusive, as without the +1 it would also take in the letter t which is not a number 
                            first = true; //sets first to true highlthing how the input has been extracted, so further extraction from another if statment does not occur 
                            break; //breaks the for loop as the user input has been extracted 
                        } else if (input[j] == '/') { //same logic 
                            expo[counter] = equation.substring(equation.indexOf(input[j]) + 1, equation.indexOf("^"));
                            first = true;
                            break;
                        } else if (input[j] == 'x') { //same logic 
                            expo[counter] = equation.substring(equation.indexOf(input[j]) + 1, equation.indexOf("^"));
                            first = true;
                            break;
                        } else if (input[j] == '+') { //same logic 
                            expo[counter] = equation.substring(equation.indexOf(input[j]) + 1, equation.indexOf("^"));
                            first = true;
                            break;
                        } else if (input[j] == '-') { //same logic
                            expo[counter] = equation.substring(equation.indexOf(input[j]) + 1, equation.indexOf("^"));
                            first = true;
                            break;
                        }
                    }

                    if (first == false) { //this checks if the loop did not detect any operations before, meaning that there is nothing before the number that has the exponent applied to it 
                        expo[counter] = equation.substring(0, equation.indexOf("^")); //saves the number before the exponent sign 
                    }
                    for (int k = equation.indexOf(input[i]); k < equation.length(); k++) { //this loop checks for the number after the sign and thus goes forward 
                        if (input[k] == 's') { //in this case it checks for s as when it is going forward it would detect the s before t and vivcersa for if it was backwards which was highlghting previosly 
                            expo[counter + 1] = equation.substring(equation.indexOf("^") + 1, equation.indexOf(input[k])); //saves it into the next index within the list as there is two numbers that would be extracted in this case. The substring checks from the sign + 1 (as the first parameter is inclusive) until the next sign which in this case would be the s
                            last = true; //sets last to true so the final if statment does not perform its code as that would extract more inputs than necessary 
                            break;//breaks the loop signifying that the value has been extracted
                        } else if (input[k] == '/') { //Same logic 
                            expo[counter + 1] = equation.substring(equation.indexOf("^") + 1, equation.indexOf(input[k]));

                            for (int n = 0; n < numbers.length; n++) {
                                if (expo[0].contains(letters[n])) {
                                    expo[0] = numbers[n];
                                }

                            }

                            for (int n = 0; n < numbers.length; n++) {
                                if (expo[1].contains(letters[n])) {
                                    expo[1] = numbers[n];
                                }

                            }

                            otherNum = equation.substring(equation.indexOf(input[k]) + 1);

                            for (int n = 0; n < numbers.length; n++) {
                                if (otherNum.contains(letters[n])) {
                                    otherNum = numbers[n];
                                }

                            }

                            answer = Math.pow(Double.valueOf(expo[0]), Double.valueOf(expo[1])) / Double.valueOf(otherNum); //performs the calculation by first taking the power of the two numbers then dividing it 

                            numAnswer = String.valueOf((int) answer);
                            char[] letterAns = numAnswer.toCharArray();
                            numAnswer = "";

                            for (int u = 0; u < letterAns.length; u++) {
                                for (int c = 0; c < numbers.length; c++) {
                                    if (String.valueOf(letterAns[u]).contains(numbers[c])) {
                                        numAnswer += letters[c];
                                    }
                                }
                            }

                            System.out.println(numAnswer);

                            last = true; //same logic as before 
                            break; //same logic 
                        } else if (input[k] == 'x') { //same logic but in this case it is for multiplcation 
                            expo[counter + 1] = equation.substring(equation.indexOf("^") + 1, equation.indexOf(input[k]));

                            for (int n = 0; n < numbers.length; n++) {
                                if (expo[0].contains(letters[n])) {
                                    expo[0] = numbers[n];
                                }

                            }

                            for (int n = 0; n < numbers.length; n++) {
                                if (expo[1].contains(letters[n])) {
                                    expo[1] = numbers[n];
                                }

                            }

                            otherNum = equation.substring(equation.indexOf(input[k]) + 1);

                            for (int n = 0; n < numbers.length; n++) {
                                if (otherNum.contains(letters[n])) {
                                    otherNum = numbers[n];
                                }

                            }

                            answer = Math.pow(Double.valueOf(expo[0]), Double.valueOf(expo[1])) * Double.valueOf(otherNum);

                            numAnswer = String.valueOf((int) answer);
                            char[] letterAns = numAnswer.toCharArray();
                            numAnswer = "";

                            for (int u = 0; u < letterAns.length; u++) {
                                for (int c = 0; c < numbers.length; c++) {
                                    if (String.valueOf(letterAns[u]).contains(numbers[c])) {
                                        numAnswer += letters[c];
                                    }
                                }
                            }

                            System.out.println(numAnswer);
                            last = true;
                            break;
                        } else if (input[k] == '+') { //same logic but for addition 
                            expo[counter + 1] = equation.substring(equation.indexOf("^") + 1, equation.indexOf(input[k]));
                            for (int n = 0; n < numbers.length; n++) {
                                if (expo[0].contains(letters[n])) {
                                    expo[0] = numbers[n];
                                }

                            }

                            for (int n = 0; n < numbers.length; n++) {
                                if (expo[1].contains(letters[n])) {
                                    expo[1] = numbers[n];
                                }

                            }

                            otherNum = equation.substring(equation.indexOf(input[k]) + 1);

                            for (int n = 0; n < numbers.length; n++) {
                                if (otherNum.contains(letters[n])) {
                                    otherNum = numbers[n];
                                }

                            }

                            answer = Math.pow(Double.valueOf(expo[0]), Double.valueOf(expo[1])) + Double.valueOf(otherNum);

                            numAnswer = String.valueOf((int)answer); 
                            char[] letterAns = numAnswer.toCharArray();
                            numAnswer = ""; 
                            
                            for (int u = 0; u < letterAns.length; u++) {
                                for (int c = 0; c < numbers.length; c++) {
                                    if (String.valueOf(letterAns[u]).contains(numbers[c])) {
                                        numAnswer += letters[c]; 
                                    }
                                }
                            }
                            
                            System.out.println(numAnswer);
                            last = true;
                            break;
                        } else if (input[k] == '-') { //same logic but for subtraction
                            expo[counter + 1] = equation.substring(equation.indexOf("^") + 1, equation.indexOf(input[k]));

                            for (int n = 0; n < numbers.length; n++) {
                                if (expo[0].contains(letters[n])) {
                                    expo[0] = numbers[n];
                                }

                            }

                            for (int n = 0; n < numbers.length; n++) {
                                if (expo[1].contains(letters[n])) {
                                    expo[1] = numbers[n];
                                }

                            }

                            otherNum = equation.substring(equation.indexOf(input[k]) + 1);

                            for (int n = 0; n < numbers.length; n++) {
                                if (otherNum.contains(letters[n])) {
                                    otherNum = numbers[n];
                                }

                            }
                            answer = Math.pow(Double.valueOf(expo[0]), Double.valueOf(expo[1])) - Double.valueOf(otherNum);

                            numAnswer = String.valueOf((int)answer); 
                            char[] letterAns = numAnswer.toCharArray();
                            numAnswer = ""; 
                            
                            for (int u = 0; u < letterAns.length; u++) {
                                for (int c = 0; c < numbers.length; c++) {
                                    if (String.valueOf(letterAns[u]).contains(numbers[c])) {
                                        numAnswer += letters[c]; 
                                    }
                                }
                            }
                            
                            System.out.println(numAnswer);
                            last = true;
                            break;
                        }
                    }

                    if (last == false) { //this checks if there was no sign after the exponent meaning it is just the number itself and nothing else
                        expo[counter + 1] = equation.substring(equation.indexOf("^") + 1); //saves the number, which is trhough finding the substring of any value after the exponent which in this case is the number

                        for (int n = 0; n < numbers.length; n++) {
                            if (expo[0].contains(letters[n])) {
                                expo[0] = numbers[n];
                            }

                        }

                        for (int n = 0; n < numbers.length; n++) {
                            if (expo[1].contains(letters[n])) {
                                expo[1] = numbers[n];
                            }

                        }

                        answer = Math.pow(Double.valueOf(expo[0]), Double.valueOf(expo[1])); //takes the power of the 2 numbers, as there is not number after meaning it is a binomial expession

                        numAnswer = String.valueOf((int)answer); 
                            char[] letterAns = numAnswer.toCharArray();
                            numAnswer = ""; 
                            
                            for (int u = 0; u < letterAns.length; u++) {
                                for (int c = 0; c < numbers.length; c++) {
                                    if (String.valueOf(letterAns[u]).contains(numbers[c])) {
                                        numAnswer += letters[c]; 
                                    }
                                }
                            }
                            
                            System.out.println(numAnswer);
                    }
                    counter++; //adds to the counter in context of experssion that surpass 3 terms, not valid in this case but is still present for possible adaptions/updates to the code

                } else if (input[i] == 's') { //checks if the sign is the sqrt, the logic for sqrt is a bit differnt as in a sqrt only one number is extracted rather than two 
                    for (int k = equation.indexOf(input[i]); k < equation.length(); k++) { //for loops that goes forward as the number will always be infront of the sqrt sign assuming the user inputs it correclyy 
                        if (input[k] == '^') { //same logic as the previous statments 
                            sqrt[counter2] = equation.substring(equation.indexOf("t") + 1, equation.indexOf(input[k]));
                            last2 = true;
                            break;
                        } else if (input[k] == '/') { //same logic
                            sqrt[counter2] = equation.substring(equation.indexOf("t") + 1, equation.indexOf(input[k]));

                            for (int n = 0; n < numbers.length; n++) {
                                if (sqrt[0].contains(letters[n])) {
                                    sqrt[0] = numbers[n];
                                }

                            }

                            otherNum = equation.substring(equation.indexOf(input[k]) + 1);

                            for (int n = 0; n < numbers.length; n++) {
                                if (otherNum.contains(letters[n])) {
                                    otherNum = numbers[n];
                                }

                            }
                            answer = Math.sqrt(Double.valueOf(sqrt[0])) / Double.valueOf(otherNum); //same logic (in this case it only has two numbers as for squrate root the user is only supposed to enter 2 values)

                            numAnswer = String.valueOf((int)answer); 
                            char[] letterAns = numAnswer.toCharArray();
                            numAnswer = ""; 
                            
                            for (int u = 0; u < letterAns.length; u++) {
                                for (int c = 0; c < numbers.length; c++) {
                                    if (String.valueOf(letterAns[u]).contains(numbers[c])) {
                                        numAnswer += letters[c]; 
                                    }
                                }
                            }
                            
                            System.out.println(numAnswer);
                            last2 = true;
                            break;
                        } else if (input[k] == 'x') { //same logic 
                            sqrt[counter2] = equation.substring(equation.indexOf("t") + 1, equation.indexOf(input[k]));

                            for (int n = 0; n < numbers.length; n++) {
                                if (sqrt[0].contains(letters[n])) {
                                    sqrt[0] = numbers[n];
                                }

                            }

                            otherNum = equation.substring(equation.indexOf(input[k]) + 1);

                            for (int n = 0; n < numbers.length; n++) {
                                if (otherNum.contains(letters[n])) {
                                    otherNum = numbers[n];
                                }

                            }
                            answer = Math.sqrt(Double.valueOf(sqrt[0])) * Double.valueOf(otherNum);

                            numAnswer = String.valueOf((int)answer); 
                            char[] letterAns = numAnswer.toCharArray();
                            numAnswer = ""; 
                            
                            for (int u = 0; u < letterAns.length; u++) {
                                for (int c = 0; c < numbers.length; c++) {
                                    if (String.valueOf(letterAns[u]).contains(numbers[c])) {
                                        numAnswer += letters[c]; 
                                    }
                                }
                            }
                            
                            System.out.println(numAnswer);
                            last2 = true;
                            break;
                        } else if (input[k] == '+') { //same logic 
                            sqrt[counter2] = equation.substring(equation.indexOf("t") + 1, equation.indexOf(input[k]));

                            for (int n = 0; n < numbers.length; n++) { //fix issue with multiple digit input 
                                if (sqrt[0].contains(letters[n])) {
                                    sqrt[0] = numbers[n];
                                }

                            }

                            otherNum = equation.substring(equation.indexOf(input[k]) + 1);

                            for (int n = 0; n < numbers.length; n++) {
                                if (otherNum.contains(letters[n])) {
                                    otherNum = numbers[n];
                                }

                            }
                            answer = Math.sqrt(Double.valueOf(sqrt[0])) + Double.valueOf(otherNum);

                            numAnswer = String.valueOf((int)answer); 
                            char[] letterAns = numAnswer.toCharArray();
                            numAnswer = ""; 
                            
                            for (int u = 0; u < letterAns.length; u++) {
                                for (int c = 0; c < numbers.length; c++) {
                                    if (String.valueOf(letterAns[u]).contains(numbers[c])) {
                                        numAnswer += letters[c]; 
                                    }
                                }
                            }
                            
                            System.out.println(numAnswer);
                            last2 = true;
                            break;
                        } else if (input[k] == '-') { //same logic 
                            sqrt[counter2] = equation.substring(equation.indexOf("t") + 1, equation.indexOf(input[k]));

                            for (int n = 0; n < numbers.length; n++) {
                                if (sqrt[0].contains(letters[n])) {
                                    sqrt[0] = numbers[n];
                                }

                            }

                            otherNum = equation.substring(equation.indexOf(input[k]) + 1);

                            for (int n = 0; n < numbers.length; n++) {
                                if (otherNum.contains(letters[n])) {
                                    otherNum = numbers[n];
                                }

                            }
                            answer = Math.sqrt(Double.valueOf(sqrt[0])) - Double.valueOf(otherNum);

                            numAnswer = String.valueOf((int)answer); 
                            char[] letterAns = numAnswer.toCharArray();
                            numAnswer = ""; 
                            
                            for (int u = 0; u < letterAns.length; u++) {
                                for (int c = 0; c < numbers.length; c++) {
                                    if (String.valueOf(letterAns[u]).contains(numbers[c])) {
                                        numAnswer += letters[c]; 
                                    }
                                }
                            }
                            
                            System.out.println(numAnswer);
                            last2 = true;
                            break;
                        }

                    }

                    if (last2 == false) { //checking if there is no operation after the sqrt and if so saving the number bside the square root  
                        sqrt[counter2] = equation.substring(equation.indexOf("t") + 1);

                        for (int n = 0; n < numbers.length; n++) {
                            if (sqrt[0].contains(letters[n])) {
                                sqrt[0] = numbers[n];
                            }

                        }

                        answer = Math.sqrt(Double.valueOf(sqrt[0])); //just takes the square root of the number as if there is no operation there would just be one (note: previous statment would check for the square root case and if another operation appreaed before the square root)

                        numAnswer = String.valueOf((int)answer); 
                            char[] letterAns = numAnswer.toCharArray();
                            numAnswer = ""; 
                            
                            for (int u = 0; u < letterAns.length; u++) {
                                for (int c = 0; c < numbers.length; c++) {
                                    if (String.valueOf(letterAns[u]).contains(numbers[c])) {
                                        numAnswer += letters[c]; 
                                    }
                                }
                            }
                            
                            System.out.println(numAnswer);
                    }
                    counter2++; //same logic as before 

                }
            }

            if (input[i] == 'x' || input[i] == '/') { //checks for next signs in BEDMAS, which in this case are multiplcation and division 
                if (input[i] == 'x') { //checks for multiplication 
                    for (int j = equation.indexOf(input[i]); j > 0; j--) { //same logic as exponent (goes backwards) 
                        if (input[j] == 't') { //same logic 
                            multi[counter3] = equation.substring(equation.indexOf(input[j]) + 1, equation.indexOf("x"));
                            first2 = true;
                            break;
                        } else if (input[j] == '^') { //same logic 
                            multi[counter3] = equation.substring(equation.indexOf(input[j]) + 1, equation.indexOf("x"));
                            first2 = true;
                            break;
                        } else if (input[j] == '/') { //same logic 
                            multi[counter3] = equation.substring(equation.indexOf(input[j]) + 1, equation.indexOf("x"));
                            first2 = true;
                            break;
                        } else if (input[j] == '+') { //same logic 
                            multi[counter3] = equation.substring(equation.indexOf(input[j]) + 1, equation.indexOf("x"));
                            first2 = true;
                            break;
                        } else if (input[j] == '-') { //same logic 
                            multi[counter3] = equation.substring(equation.indexOf(input[j]) + 1, equation.indexOf("x"));
                            first2 = true;
                            break;
                        }
                    }

                    if (first2 == false && check2 == true) { //same logic as before however in this case check2 is used for checking if the full experssion has multiplcation (e.g. 3 x 3 x 3)
                        multi[counter3] = equation.substring(0, equation.indexOf("x"));
                        check2 = false;
                    }
                    for (int k = equation.indexOf(input[i]); k < equation.length(); k++) { //same logic as exponents (going forwards) 
                        if (input[k] == 's') {
                            multi[counter3 + 1] = equation.substring(equation.indexOf("x") + 1, equation.indexOf(input[k]));
                            for (int n = 0; n < numbers.length; n++) {
                                if (multi[0].contains(letters[n])) {
                                    multi[0] = numbers[n];
                                }

                            }

                            for (int n = 0; n < numbers.length; n++) {
                                if (multi[1].contains(letters[n])) {
                                    multi[1] = numbers[n];
                                }

                            }

                            otherNum = equation.substring(equation.indexOf("t") + 1);

                            for (int n = 0; n < numbers.length; n++) {
                                if (otherNum.contains(letters[n])) {
                                    otherNum = numbers[n];
                                }

                            }
                            answer = Math.sqrt(Double.valueOf(otherNum)) * Double.valueOf(multi[0]); //in the case of why multi[0] is used it is used becuase multi[1] would be empty as when square root is used it is only possible to have a 2 term euqation meaning there would only be 2 total numbers not 3

                            numAnswer = String.valueOf((int)answer); 
                            char[] letterAns = numAnswer.toCharArray();
                            numAnswer = ""; 
                            
                            for (int u = 0; u < letterAns.length; u++) {
                                for (int c = 0; c < numbers.length; c++) {
                                    if (String.valueOf(letterAns[u]).contains(numbers[c])) {
                                        numAnswer += letters[c]; 
                                    }
                                }
                            }
                            
                            System.out.println(numAnswer);
                            last3 = true;
                            break;
                        } else if (input[k] == '^') { //same logic as before 
                            multi[counter3 + 1] = equation.substring(equation.indexOf("x") + 1, equation.indexOf(input[k]));

                            for (int n = 0; n < numbers.length; n++) {
                                if (multi[0].contains(letters[n])) {
                                    multi[0] = numbers[n];
                                }

                            }

                            for (int n = 0; n < numbers.length; n++) {
                                if (multi[1].contains(letters[n])) {
                                    multi[1] = numbers[n];
                                }

                            }

                            otherNum = equation.substring(equation.indexOf(input[k]) + 1);

                            for (int n = 0; n < numbers.length; n++) {
                                if (otherNum.contains(letters[n])) {
                                    otherNum = numbers[n];
                                }

                            }
                            answer = Math.pow(Double.valueOf(multi[1]), Double.valueOf(otherNum)) * Double.valueOf(multi[0]); //in this case it is multi[1] in the math.pow becuase in this case the second number would be the one the exponent is applied to as this is after the multiplcation sign (e.g. 3 x 4 ^ 7) (multi[1] in this case would be 4)

                            numAnswer = String.valueOf((int)answer); 
                            char[] letterAns = numAnswer.toCharArray();
                            numAnswer = ""; 
                            
                            for (int u = 0; u < letterAns.length; u++) {
                                for (int c = 0; c < numbers.length; c++) {
                                    if (String.valueOf(letterAns[u]).contains(numbers[c])) {
                                        numAnswer += letters[c]; 
                                    }
                                }
                            }
                            
                            System.out.println(numAnswer);
                            last3 = true;
                            break;
                        } else if (input[k] == '/') { //same logic as before 
                            multi[counter3 + 1] = equation.substring(equation.indexOf("x") + 1, equation.indexOf(input[k]));

                            for (int n = 0; n < numbers.length; n++) {
                                if (multi[0].contains(letters[n])) {
                                    multi[0] = numbers[n];
                                }

                            }

                            for (int n = 0; n < numbers.length; n++) {
                                if (multi[1].contains(letters[n])) {
                                    multi[1] = numbers[n];
                                }

                            }

                            otherNum = equation.substring(equation.indexOf(input[k]) + 1);

                            for (int n = 0; n < numbers.length; n++) {
                                if (otherNum.contains(letters[n])) {
                                    otherNum = numbers[n];
                                }

                            }
                            answer = Double.valueOf(multi[0]) * Double.valueOf(multi[1]) / Double.valueOf(otherNum); //in this case multipcation is done first then division as it goes left to right in terms of BEDMAS

                            numAnswer = String.valueOf((int)answer); 
                            char[] letterAns = numAnswer.toCharArray();
                            numAnswer = ""; 
                            
                            for (int u = 0; u < letterAns.length; u++) {
                                for (int c = 0; c < numbers.length; c++) {
                                    if (String.valueOf(letterAns[u]).contains(numbers[c])) {
                                        numAnswer += letters[c]; 
                                    }
                                }
                            }
                            
                            System.out.println(numAnswer);
                            last3 = true;
                            break;
                        } else if (input[k] == '+') {  //same logic as before 
                            multi[counter3 + 1] = equation.substring(equation.indexOf("x") + 1, equation.indexOf(input[k]));

                            for (int n = 0; n < numbers.length; n++) {
                                if (multi[0].contains(letters[n])) {
                                    multi[0] = numbers[n];
                                }

                            }

                            for (int n = 0; n < numbers.length; n++) {
                                if (multi[1].contains(letters[n])) {
                                    multi[1] = numbers[n];
                                }

                            }

                            otherNum = equation.substring(equation.indexOf(input[k]) + 1);

                            for (int n = 0; n < numbers.length; n++) {
                                if (otherNum.contains(letters[n])) {
                                    otherNum = numbers[n];
                                }

                            }
                            answer = Double.valueOf(multi[0]) * Double.valueOf(multi[1]) + Double.valueOf(otherNum); // in this case multicpation is done first then addition due to bedmas

                            numAnswer = String.valueOf((int)answer); 
                            char[] letterAns = numAnswer.toCharArray();
                            numAnswer = ""; 
                            
                            for (int u = 0; u < letterAns.length; u++) {
                                for (int c = 0; c < numbers.length; c++) {
                                    if (String.valueOf(letterAns[u]).contains(numbers[c])) {
                                        numAnswer += letters[c]; 
                                    }
                                }
                            }
                            
                            System.out.println(numAnswer);
                            last3 = true;
                            break;
                        } else if (input[k] == '-') { //same logic as before 
                            multi[counter3 + 1] = equation.substring(equation.indexOf("x") + 1, equation.indexOf(input[k]));

                            for (int n = 0; n < numbers.length; n++) {
                                if (multi[0].contains(letters[n])) {
                                    multi[0] = numbers[n];
                                }

                            }

                            for (int n = 0; n < numbers.length; n++) {
                                if (multi[1].contains(letters[n])) {
                                    multi[1] = numbers[n];
                                }

                            }

                            otherNum = equation.substring(equation.indexOf(input[k]) + 1);

                            for (int n = 0; n < numbers.length; n++) {
                                if (otherNum.contains(letters[n])) {
                                    otherNum = numbers[n];
                                }

                            }
                            answer = Double.valueOf(multi[0]) * Double.valueOf(multi[1]) - Double.valueOf(otherNum);

                            numAnswer = String.valueOf((int)answer); 
                            char[] letterAns = numAnswer.toCharArray();
                            numAnswer = ""; 
                            
                            for (int u = 0; u < letterAns.length; u++) {
                                for (int c = 0; c < numbers.length; c++) {
                                    if (String.valueOf(letterAns[u]).contains(numbers[c])) {
                                        numAnswer += letters[c]; 
                                    }
                                }
                            }
                            
                            System.out.println(numAnswer);
                            last3 = true;
                            break;
                        }
                    }

                    //checks for multiple occurances
                    int checker = 0;
                    for (int l = 0; l < equation.length(); l++) { //goes though every element in the list 
                        if (input[l] == 'x') { //if the input is x it incmrents counter, so we can find the number of multipcation signs inputted by the user 
                            checker++;
                        }
                    }

                    if (last3 == false && check == true && checker > 1) { //checks if there are multiple occuances 
                        multi[counter3 + 1] = equation.substring(equation.indexOf("x") + 1, secondIndex); //saves the third number into the multiplication list 
                        check = false; //sets check to false so the answer can be outputted 

                    } else if (last3 == false && check == false && checker > 1) { //this is done to do the actual calculation and print the answer or the product 
                        multi[counter3 + 1] = equation.substring(secondIndex + 1);

                        for (int n = 0; n < numbers.length; n++) {
                            if (multi[0].contains(letters[n])) {
                                multi[0] = numbers[n];
                            }

                        }

                        for (int n = 0; n < numbers.length; n++) {
                            if (multi[1].contains(letters[n])) {
                                multi[1] = numbers[n];
                            }

                        }

                        for (int n = 0; n < numbers.length; n++) {
                            if (multi[2].contains(letters[n])) {
                                multi[2] = numbers[n];
                            }

                        }
                        answer = Double.valueOf(multi[0]) * Double.valueOf(multi[1]) * Double.valueOf(multi[2]); //find the product of the three numbers 

                        numAnswer = String.valueOf((int)answer); 
                            char[] letterAns = numAnswer.toCharArray();
                            numAnswer = ""; 
                            
                            for (int u = 0; u < letterAns.length; u++) {
                                for (int c = 0; c < numbers.length; c++) {
                                    if (String.valueOf(letterAns[u]).contains(numbers[c])) {
                                        numAnswer += letters[c]; 
                                    }
                                }
                            }
                            
                            System.out.println(numAnswer);
                    } else if (last3 == false) { //same logic as previous ones, this would be if the equation just had two terms e.g. 2 x 3
                        multi[counter3 + 1] = equation.substring(equation.indexOf("x") + 1);

                        for (int n = 0; n < numbers.length; n++) {
                            if (multi[0].contains(letters[n])) {
                                multi[0] = numbers[n];
                            }

                        }

                        for (int n = 0; n < numbers.length; n++) {
                            if (multi[1].contains(letters[n])) {
                                multi[1] = numbers[n];
                            }

                        }

                        answer = Double.valueOf(multi[0]) * Double.valueOf(multi[1]);

                        numAnswer = String.valueOf((int)answer); 
                            char[] letterAns = numAnswer.toCharArray();
                            numAnswer = ""; 
                            
                            for (int u = 0; u < letterAns.length; u++) {
                                for (int c = 0; c < numbers.length; c++) {
                                    if (String.valueOf(letterAns[u]).contains(numbers[c])) {
                                        numAnswer += letters[c]; 
                                    }
                                }
                            }
                            
                            System.out.println(numAnswer);
                    }
                    counter3++;

                } else if (input[i] == '/') {
                    for (int j = equation.indexOf(input[i]); j > 0; j--) { //same logic as before 
                        if (input[j] == 't') {
                            divide[counter4] = equation.substring(equation.indexOf(input[j]) + 1, equation.indexOf("/"));
                            first3 = true;
                            break;
                        } else if (input[j] == '^') {
                            divide[counter4] = equation.substring(equation.indexOf(input[j]) + 1, equation.indexOf("/"));
                            first3 = true;
                            break;
                        } else if (input[j] == 'x') {
                            divide[counter4] = equation.substring(equation.indexOf(input[j]) + 1, equation.indexOf("/"));
                            first3 = true;
                            break;
                        } else if (input[j] == '+') {
                            divide[counter4] = equation.substring(equation.indexOf(input[j]) + 1, equation.indexOf("/"));
                            first3 = true;
                            break;
                        } else if (input[j] == '-') {
                            divide[counter4] = equation.substring(equation.indexOf(input[j]) + 1, equation.indexOf("/"));
                            first3 = true;
                            break;
                        }
                    }

                    if (first3 == false && check3 == true) { //same logic as before 
                        divide[counter4] = equation.substring(0, equation.indexOf("/"));
                        check3 = false;
                    }
                    for (int k = equation.indexOf(input[i]); k < equation.length(); k++) { //same logic as before 
                        if (input[k] == 's') {
                            divide[counter4 + 1] = equation.substring(equation.indexOf("/") + 1, equation.indexOf(input[k]));

                            for (int n = 0; n < numbers.length; n++) {
                                if (divide[0].contains(letters[n])) {
                                    divide[0] = numbers[n];
                                }

                            }

                            for (int n = 0; n < numbers.length; n++) {
                                if (divide[1].contains(letters[n])) {
                                    divide[1] = numbers[n];
                                }

                            }

                            otherNum = equation.substring(equation.indexOf("t") + 1);

                            for (int n = 0; n < numbers.length; n++) {
                                if (otherNum.contains(letters[n])) {
                                    otherNum = numbers[n];
                                }

                            }
                            answer = Double.valueOf(divide[0]) / Math.sqrt(Double.valueOf(otherNum));

                            numAnswer = String.valueOf((int)answer); 
                            char[] letterAns = numAnswer.toCharArray();
                            numAnswer = ""; 
                            
                            for (int u = 0; u < letterAns.length; u++) {
                                for (int c = 0; c < numbers.length; c++) {
                                    if (String.valueOf(letterAns[u]).contains(numbers[c])) {
                                        numAnswer += letters[c]; 
                                    }
                                }
                            }
                            
                            System.out.println(numAnswer);
                            last4 = true;
                            break;
                        } else if (input[k] == '^') { //same logic as before
                            divide[counter4 + 1] = equation.substring(equation.indexOf("/") + 1, equation.indexOf(input[k]));

                            for (int n = 0; n < numbers.length; n++) {
                                if (divide[0].contains(letters[n])) {
                                    divide[0] = numbers[n];
                                }

                            }

                            for (int n = 0; n < numbers.length; n++) {
                                if (divide[1].contains(letters[n])) {
                                    divide[1] = numbers[n];
                                }

                            }

                            otherNum = equation.substring(equation.indexOf(input[k]) + 1);

                            for (int n = 0; n < numbers.length; n++) {
                                if (otherNum.contains(letters[n])) {
                                    otherNum = numbers[n];
                                }

                            }
                            answer = Double.valueOf(divide[0]) / Math.pow(Double.valueOf(divide[1]), Double.valueOf(otherNum));

                            numAnswer = String.valueOf((int)answer); 
                            char[] letterAns = numAnswer.toCharArray();
                            numAnswer = ""; 
                            
                            for (int u = 0; u < letterAns.length; u++) {
                                for (int c = 0; c < numbers.length; c++) {
                                    if (String.valueOf(letterAns[u]).contains(numbers[c])) {
                                        numAnswer += letters[c]; 
                                    }
                                }
                            }
                            
                            System.out.println(numAnswer);
                            last4 = true;
                            break;
                        } else if (input[k] == 'x') { //same logic as before 
                            divide[counter4 + 1] = equation.substring(equation.indexOf("/") + 1, equation.indexOf(input[k]));

                            for (int n = 0; n < numbers.length; n++) {
                                if (divide[0].contains(letters[n])) {
                                    divide[0] = numbers[n];
                                }

                            }

                            for (int n = 0; n < numbers.length; n++) {
                                if (divide[1].contains(letters[n])) {
                                    divide[1] = numbers[n];
                                }

                            }

                            otherNum = equation.substring(equation.indexOf(input[k]) + 1);

                            for (int n = 0; n < numbers.length; n++) {
                                if (otherNum.contains(letters[n])) {
                                    otherNum = numbers[n];
                                }

                            }
                            answer = Double.valueOf(divide[0]) / Double.valueOf(divide[1]) * Double.valueOf(otherNum);

                            numAnswer = String.valueOf((int)answer); 
                            char[] letterAns = numAnswer.toCharArray();
                            numAnswer = ""; 
                            
                            for (int u = 0; u < letterAns.length; u++) {
                                for (int c = 0; c < numbers.length; c++) {
                                    if (String.valueOf(letterAns[u]).contains(numbers[c])) {
                                        numAnswer += letters[c]; 
                                    }
                                }
                            }
                            
                            System.out.println(numAnswer);
                            last4 = true;
                            break;
                        } else if (input[k] == '+') { //same logic as before
                            divide[counter4 + 1] = equation.substring(equation.indexOf("/") + 1, equation.indexOf(input[k]));

                            for (int n = 0; n < numbers.length; n++) {
                                if (divide[0].contains(letters[n])) {
                                    divide[0] = numbers[n];
                                }

                            }

                            for (int n = 0; n < numbers.length; n++) {
                                if (divide[1].contains(letters[n])) {
                                    divide[1] = numbers[n];
                                }

                            }

                            otherNum = equation.substring(equation.indexOf(input[k]) + 1);

                            for (int n = 0; n < numbers.length; n++) {
                                if (otherNum.contains(letters[n])) {
                                    otherNum = numbers[n];
                                }

                            }
                            answer = Double.valueOf(divide[0]) / Double.valueOf(divide[1]) + Double.valueOf(otherNum);
                            numAnswer = String.valueOf((int)answer); 
                            char[] letterAns = numAnswer.toCharArray();
                            numAnswer = ""; 
                            
                            for (int u = 0; u < letterAns.length; u++) {
                                for (int c = 0; c < numbers.length; c++) {
                                    if (String.valueOf(letterAns[u]).contains(numbers[c])) {
                                        numAnswer += letters[c]; 
                                    }
                                }
                            }
                            
                            System.out.println(numAnswer);
                            last4 = true;
                            break;
                        } else if (input[k] == '-') { //same logic as before 
                            divide[counter4 + 1] = equation.substring(equation.indexOf("/") + 1, equation.indexOf(input[k]));

                            for (int n = 0; n < numbers.length; n++) {
                                if (divide[0].contains(letters[n])) {
                                    divide[0] = numbers[n];
                                }

                            }

                            for (int n = 0; n < numbers.length; n++) {
                                if (divide[1].contains(letters[n])) {
                                    divide[1] = numbers[n];
                                }

                            }

                            otherNum = equation.substring(equation.indexOf(input[k]) + 1);

                            for (int n = 0; n < numbers.length; n++) {
                                if (otherNum.contains(letters[n])) {
                                    otherNum = numbers[n];
                                }

                            }
                            answer = Double.valueOf(divide[0]) / Double.valueOf(divide[1]) - Double.valueOf(otherNum);

                            numAnswer = String.valueOf((int)answer); 
                            char[] letterAns = numAnswer.toCharArray();
                            numAnswer = ""; 
                            
                            for (int u = 0; u < letterAns.length; u++) {
                                for (int c = 0; c < numbers.length; c++) {
                                    if (String.valueOf(letterAns[u]).contains(numbers[c])) {
                                        numAnswer += letters[c]; 
                                    }
                                }
                            }
                            
                            System.out.println(numAnswer);
                            last4 = true;
                            break;
                        }
                    }

                    //same logic as before for the second occurance 
                    int checker = 0;
                    for (int l = 0; l < equation.length(); l++) {
                        if (input[l] == '/') {
                            checker++;
                        }
                    }

                    if (last4 == false && check4 == true && checker > 1) { //same logic as before (multiplcation) 
                        divide[counter4 + 1] = equation.substring(equation.indexOf("/") + 1, secondIndex2);
                        check4 = false;

                    } else if (last4 == false && check4 == false && checker > 1) { //same logic  as before 
                        divide[counter4 + 1] = equation.substring(secondIndex2 + 1);

                        for (int n = 0; n < numbers.length; n++) {
                            if (divide[0].contains(letters[n])) {
                                divide[0] = numbers[n];
                            }

                        }

                        for (int n = 0; n < numbers.length; n++) {
                            if (divide[1].contains(letters[n])) {
                                divide[1] = numbers[n];
                            }

                        }

                        for (int n = 0; n < numbers.length; n++) {
                            if (divide[2].contains(letters[n])) {
                                divide[2] = numbers[n];
                            }

                        }
                        answer = Double.valueOf(divide[0]) / Double.valueOf(divide[1]) / Double.valueOf(divide[2]);

                        numAnswer = String.valueOf((int)answer); 
                            char[] letterAns = numAnswer.toCharArray();
                            numAnswer = ""; 
                            
                            for (int u = 0; u < letterAns.length; u++) {
                                for (int c = 0; c < numbers.length; c++) {
                                    if (String.valueOf(letterAns[u]).contains(numbers[c])) {
                                        numAnswer += letters[c]; 
                                    }
                                }
                            }
                            
                            System.out.println(numAnswer);
                    } else if (last4 == false) { //same logic as before 
                        divide[counter4 + 1] = equation.substring(equation.indexOf("/") + 1);

                        for (int n = 0; n < numbers.length; n++) {
                            if (divide[0].contains(letters[n])) {
                                divide[0] = numbers[n];
                            }

                        }

                        for (int n = 0; n < numbers.length; n++) {
                            if (divide[1].contains(letters[n])) {
                                divide[1] = numbers[n];
                            }

                        }

                        answer = Double.valueOf(divide[0]) / Double.valueOf(divide[1]); //same logic as before 

                        numAnswer = String.valueOf((int)answer); 
                            char[] letterAns = numAnswer.toCharArray();
                            numAnswer = ""; 
                            
                            for (int u = 0; u < letterAns.length; u++) {
                                for (int c = 0; c < numbers.length; c++) {
                                    if (String.valueOf(letterAns[u]).contains(numbers[c])) {
                                        numAnswer += letters[c]; 
                                    }
                                }
                            }
                            
                            System.out.println(numAnswer);
                    }
                    counter4++;

                }

            }

            if (input[i] == '+' || input[i] == '-') { //now checks for the next part of bedmas addition and subtraction
                if (input[i] == '+') { //checks for addition 
                    for (int j = equation.indexOf(input[i]); j > 0; j--) { //same logic as before (backwards) 
                        if (input[j] == 't') { //same logic as before 
                            add[counter5] = equation.substring(equation.indexOf(input[j]) + 1, equation.indexOf("+"));
                            first4 = true;
                            break;
                        } else if (input[j] == '^') { //same logic as before 
                            add[counter5] = equation.substring(equation.indexOf(input[j]) + 1, equation.indexOf("+"));
                            first4 = true;
                            break;
                        } else if (input[j] == '/') { //same logic as before
                            add[counter5] = equation.substring(equation.indexOf(input[j]) + 1, equation.indexOf("+"));
                            first4 = true;
                            break;
                        } else if (input[j] == 'x') { //same logic as before 
                            add[counter5] = equation.substring(equation.indexOf(input[j]) + 1, equation.indexOf("+"));
                            first4 = true;
                            break;
                        } else if (input[j] == '-') { //same logic as before 
                            add[counter5] = equation.substring(equation.indexOf(input[j]) + 1, equation.indexOf("+"));
                            first4 = true;
                            break;
                        }
                    }

                    if (first4 == false && check7 == true) { //same logic as before 
                        add[counter5] = equation.substring(0, equation.indexOf("+"));
                        check7 = false;
                    }
                    for (int k = equation.indexOf(input[i]); k < equation.length(); k++) { //same logic as before 
                        if (input[k] == 's') {
                            add[counter5 + 1] = equation.substring(equation.indexOf("+") + 1, equation.indexOf(input[k]));

                            for (int n = 0; n < numbers.length; n++) {
                                if (add[0].contains(letters[n])) {
                                    add[0] = numbers[n];
                                }

                            }

                            for (int n = 0; n < numbers.length; n++) {
                                if (add[1].contains(letters[n])) {
                                    add[1] = numbers[n];
                                }

                            }

                            otherNum = equation.substring(equation.indexOf("t") + 1);

                            for (int n = 0; n < numbers.length; n++) {
                                if (otherNum.contains(letters[n])) {
                                    otherNum = numbers[n];
                                }

                            }
                            answer = Math.sqrt(Double.valueOf(otherNum)) + Double.valueOf(add[0]);

                            numAnswer = String.valueOf((int)answer); 
                            char[] letterAns = numAnswer.toCharArray();
                            numAnswer = ""; 
                            
                            for (int u = 0; u < letterAns.length; u++) {
                                for (int c = 0; c < numbers.length; c++) {
                                    if (String.valueOf(letterAns[u]).contains(numbers[c])) {
                                        numAnswer += letters[c]; 
                                    }
                                }
                            }
                            
                            System.out.println(numAnswer);
                            last5 = true;
                            break;
                        } else if (input[k] == '^') { //same logic as before
                            add[counter5 + 1] = equation.substring(equation.indexOf("+") + 1, equation.indexOf(input[k])); //same logic as before

                            for (int n = 0; n < numbers.length; n++) {
                                if (add[0].contains(letters[n])) {
                                    add[0] = numbers[n];
                                }

                            }

                            for (int n = 0; n < numbers.length; n++) {
                                if (add[1].contains(letters[n])) {
                                    add[1] = numbers[n];
                                }

                            }

                            otherNum = equation.substring(equation.indexOf(input[k]) + 1);

                            for (int n = 0; n < numbers.length; n++) {
                                if (otherNum.contains(letters[n])) {
                                    otherNum = numbers[n];
                                }

                            }
                            answer = Math.pow(Double.valueOf(add[1]), Double.valueOf(otherNum)) + Double.valueOf(add[0]); //same logic as before 

                            numAnswer = String.valueOf((int)answer); 
                            char[] letterAns = numAnswer.toCharArray();
                            numAnswer = ""; 
                            
                            for (int u = 0; u < letterAns.length; u++) {
                                for (int c = 0; c < numbers.length; c++) {
                                    if (String.valueOf(letterAns[u]).contains(numbers[c])) {
                                        numAnswer += letters[c]; 
                                    }
                                }
                            }
                            
                            System.out.println(numAnswer);
                            last5 = true;
                            break;
                        } else if (input[k] == '/') { //same logic as before 
                            add[counter5 + 1] = equation.substring(equation.indexOf("+") + 1, equation.indexOf(input[k]));

                            for (int n = 0; n < numbers.length; n++) {
                                if (add[0].contains(letters[n])) {
                                    add[0] = numbers[n];
                                }

                            }

                            for (int n = 0; n < numbers.length; n++) {
                                if (add[1].contains(letters[n])) {
                                    add[1] = numbers[n];
                                }

                            }

                            otherNum = equation.substring(equation.indexOf(input[k]) + 1);

                            for (int n = 0; n < numbers.length; n++) {
                                if (otherNum.contains(letters[n])) {
                                    otherNum = numbers[n];
                                }

                            }
                            answer = (Double.valueOf(add[1]) / Double.valueOf(otherNum)) + Double.valueOf(add[0]); //same logic as before

                            numAnswer = String.valueOf((int)answer); 
                            char[] letterAns = numAnswer.toCharArray();
                            numAnswer = ""; 
                            
                            for (int u = 0; u < letterAns.length; u++) {
                                for (int c = 0; c < numbers.length; c++) {
                                    if (String.valueOf(letterAns[u]).contains(numbers[c])) {
                                        numAnswer += letters[c]; 
                                    }
                                }
                            }
                            
                            System.out.println(numAnswer);
                            last5 = true;
                            break;
                        } else if (input[k] == 'x') { //same logic as before 
                            add[counter5 + 1] = equation.substring(equation.indexOf("+") + 1, equation.indexOf(input[k]));

                            for (int n = 0; n < numbers.length; n++) {
                                if (add[0].contains(letters[n])) {
                                    add[0] = numbers[n];
                                }

                            }

                            for (int n = 0; n < numbers.length; n++) {
                                if (add[1].contains(letters[n])) {
                                    add[1] = numbers[n];
                                }

                            }

                            otherNum = equation.substring(equation.indexOf(input[k]) + 1);

                            for (int n = 0; n < numbers.length; n++) {
                                if (otherNum.contains(letters[n])) {
                                    otherNum = numbers[n];
                                }

                            }
                            answer = Double.valueOf(otherNum) * Double.valueOf(add[1]) + Double.valueOf(add[0]);

                            numAnswer = String.valueOf((int)answer); 
                            char[] letterAns = numAnswer.toCharArray();
                            numAnswer = ""; 
                            
                            for (int u = 0; u < letterAns.length; u++) {
                                for (int c = 0; c < numbers.length; c++) {
                                    if (String.valueOf(letterAns[u]).contains(numbers[c])) {
                                        numAnswer += letters[c]; 
                                    }
                                }
                            }
                            
                            System.out.println(numAnswer);
                            last5 = true;
                            break;
                        } else if (input[k] == '-') { //same logic as before
                            add[counter5 + 1] = equation.substring(equation.indexOf("+") + 1, equation.indexOf(input[k]));

                            for (int n = 0; n < numbers.length; n++) {
                                if (add[0].contains(letters[n])) {
                                    add[0] = numbers[n];
                                }

                            }

                            for (int n = 0; n < numbers.length; n++) {
                                if (add[1].contains(letters[n])) {
                                    add[1] = numbers[n];
                                }

                            }

                            otherNum = equation.substring(equation.indexOf(input[k]) + 1);

                            for (int n = 0; n < numbers.length; n++) {
                                if (otherNum.contains(letters[n])) {
                                    otherNum = numbers[n];
                                }

                            }
                            answer = Double.valueOf(add[0]) + Double.valueOf(add[1]) - Double.valueOf(otherNum);

                            numAnswer = String.valueOf((int)answer); 
                            char[] letterAns = numAnswer.toCharArray();
                            numAnswer = ""; 
                            
                            for (int u = 0; u < letterAns.length; u++) {
                                for (int c = 0; c < numbers.length; c++) {
                                    if (String.valueOf(letterAns[u]).contains(numbers[c])) {
                                        numAnswer += letters[c]; 
                                    }
                                }
                            }
                            
                            System.out.println(numAnswer);
                            last5 = true;
                            break;
                        }
                    }

                    //same logic as before for double occuracnes 
                    int checker = 0;
                    for (int l = 0; l < equation.length(); l++) {
                        if (input[l] == '+') {
                            checker++;
                        }
                    }

                    if (last5 == false && check5 == true && checker > 1) { //same logic as before 
                        add[counter5 + 1] = equation.substring(equation.indexOf("+") + 1, secondIndex3);
                        check5 = false;

                    } else if (last5 == false && check5 == false && checker > 1) { //same logic as before
                        add[counter5 + 1] = equation.substring(secondIndex3 + 1);

                        for (int n = 0; n < numbers.length; n++) {
                            if (add[0].contains(letters[n])) {
                                add[0] = numbers[n];
                            }

                        }

                        for (int n = 0; n < numbers.length; n++) {
                            if (add[1].contains(letters[n])) {
                                add[1] = numbers[n];
                            }

                        }

                        for (int n = 0; n < numbers.length; n++) {
                            if (add[2].contains(letters[n])) {
                                add[2] = numbers[n];
                            }

                        }
                        answer = Double.valueOf(add[0]) + Double.valueOf(add[1]) + Double.valueOf(add[2]);

                        numAnswer = String.valueOf((int)answer); 
                            char[] letterAns = numAnswer.toCharArray();
                            numAnswer = ""; 
                            
                            for (int u = 0; u < letterAns.length; u++) {
                                for (int c = 0; c < numbers.length; c++) {
                                    if (String.valueOf(letterAns[u]).contains(numbers[c])) {
                                        numAnswer += letters[c]; 
                                    }
                                }
                            }
                            
                            System.out.println(numAnswer);
                    } else if (last5 == false) { //same logic as before 
                        add[counter5 + 1] = equation.substring(equation.indexOf("+") + 1);

                        for (int n = 0; n < numbers.length; n++) {
                            if (add[0].contains(letters[n])) {
                                add[0] = numbers[n];
                            }

                        }

                        for (int n = 0; n < numbers.length; n++) {
                            if (add[1].contains(letters[n])) {
                                add[1] = numbers[n];
                            }

                        }

                        answer = Double.valueOf(add[0]) + Double.valueOf(add[1]);
                        numAnswer = String.valueOf((int)answer); 
                            char[] letterAns = numAnswer.toCharArray();
                            numAnswer = ""; 
                            
                            for (int u = 0; u < letterAns.length; u++) {
                                for (int c = 0; c < numbers.length; c++) {
                                    if (String.valueOf(letterAns[u]).contains(numbers[c])) {
                                        numAnswer += letters[c]; 
                                    }
                                }
                            }
                            
                            System.out.println(numAnswer);

                    }
                    counter5++;

                } else if (input[i] == '-') { //same logic as before but for subtraction
                    for (int j = equation.indexOf(input[i]); j > 0; j--) {
                        if (input[j] == 't') {
                            sub[counter6] = equation.substring(equation.indexOf(input[j]) + 1, equation.indexOf("-"));
                            first5 = true;
                            break;
                        } else if (input[j] == '^') {
                            sub[counter6] = equation.substring(equation.indexOf(input[j]) + 1, equation.indexOf("-"));
                            first5 = true;
                            break;
                        } else if (input[j] == 'x') {
                            sub[counter6] = equation.substring(equation.indexOf(input[j]) + 1, equation.indexOf("-"));
                            first5 = true;
                            break;
                        } else if (input[j] == '+') {
                            sub[counter6] = equation.substring(equation.indexOf(input[j]) + 1, equation.indexOf("-"));
                            first5 = true;
                            break;
                        } else if (input[j] == '/') {
                            sub[counter6] = equation.substring(equation.indexOf(input[j]) + 1, equation.indexOf("-"));
                            first5 = true;
                            break;
                        }
                    }

                    if (first5 == false && check8 == true) { //same logic as before
                        sub[counter6] = equation.substring(0, equation.indexOf("-"));
                        check8 = false;
                    }
                    for (int k = equation.indexOf(input[i]); k < equation.length(); k++) { //same logic as bfore 
                        if (input[k] == 's') {
                            sub[counter6 + 1] = equation.substring(equation.indexOf("-") + 1, equation.indexOf(input[k]));

                            for (int n = 0; n < numbers.length; n++) {
                                if (sub[0].contains(letters[n])) {
                                    sub[0] = numbers[n];
                                }

                            }

                            for (int n = 0; n < numbers.length; n++) {
                                if (sub[1].contains(letters[n])) {
                                    sub[1] = numbers[n];
                                }

                            }

                            otherNum = equation.substring(equation.indexOf("t") + 1);

                            for (int n = 0; n < numbers.length; n++) {
                                if (otherNum.contains(letters[n])) {
                                    otherNum = numbers[n];
                                }

                            }
                            answer = Double.valueOf(sub[0]) - Math.sqrt(Double.valueOf(otherNum));

                            numAnswer = String.valueOf((int)answer); 
                            char[] letterAns = numAnswer.toCharArray();
                            numAnswer = ""; 
                            
                            for (int u = 0; u < letterAns.length; u++) {
                                for (int c = 0; c < numbers.length; c++) {
                                    if (String.valueOf(letterAns[u]).contains(numbers[c])) {
                                        numAnswer += letters[c]; 
                                    }
                                }
                            }
                            
                            System.out.println(numAnswer);
                            last6 = true;
                            break;
                        } else if (input[k] == '^') { //same logic as before
                            sub[counter6 + 1] = equation.substring(equation.indexOf("-") + 1, equation.indexOf(input[k]));

                            for (int n = 0; n < numbers.length; n++) {
                                if (sub[0].contains(letters[n])) {
                                    sub[0] = numbers[n];
                                }

                            }

                            for (int n = 0; n < numbers.length; n++) {
                                if (sub[1].contains(letters[n])) {
                                    sub[1] = numbers[n];
                                }

                            }

                            otherNum = equation.substring(equation.indexOf(input[k]) + 1);

                            for (int n = 0; n < numbers.length; n++) {
                                if (otherNum.contains(letters[n])) {
                                    otherNum = numbers[n];
                                }

                            }
                            answer = Math.pow(Double.valueOf(sub[1]), Double.valueOf(otherNum)) - Double.valueOf(sub[0]);

                            numAnswer = String.valueOf((int)answer); 
                            char[] letterAns = numAnswer.toCharArray();
                            numAnswer = ""; 
                            
                            for (int u = 0; u < letterAns.length; u++) {
                                for (int c = 0; c < numbers.length; c++) {
                                    if (String.valueOf(letterAns[u]).contains(numbers[c])) {
                                        numAnswer += letters[c]; 
                                    }
                                }
                            }
                            
                            System.out.println(numAnswer);
                            last6 = true;
                            break;
                        } else if (input[k] == 'x') { //same logic as before 
                            sub[counter6 + 1] = equation.substring(equation.indexOf("-") + 1, equation.indexOf(input[k]));

                            for (int n = 0; n < numbers.length; n++) {
                                if (sub[0].contains(letters[n])) {
                                    sub[0] = numbers[n];
                                }

                            }

                            for (int n = 0; n < numbers.length; n++) {
                                if (sub[1].contains(letters[n])) {
                                    sub[1] = numbers[n];
                                }

                            }

                            otherNum = equation.substring(equation.indexOf(input[k]) + 1);

                            for (int n = 0; n < numbers.length; n++) {
                                if (otherNum.contains(letters[n])) {
                                    otherNum = numbers[n];
                                }

                            }
                            answer = Double.valueOf(otherNum) * Double.valueOf(sub[1]) - Double.valueOf(sub[0]);

                            numAnswer = String.valueOf((int)answer); 
                            char[] letterAns = numAnswer.toCharArray();
                            numAnswer = ""; 
                            
                            for (int u = 0; u < letterAns.length; u++) {
                                for (int c = 0; c < numbers.length; c++) {
                                    if (String.valueOf(letterAns[u]).contains(numbers[c])) {
                                        numAnswer += letters[c]; 
                                    }
                                }
                            }
                            
                            System.out.println(numAnswer);
                            last6 = true;
                            break;
                        } else if (input[k] == '+') { //same logic as before 
                            sub[counter6 + 1] = equation.substring(equation.indexOf("-") + 1, equation.indexOf(input[k]));
                            for (int n = 0; n < numbers.length; n++) {
                                if (sub[0].contains(letters[n])) {
                                    sub[0] = numbers[n];
                                }

                            }

                            for (int n = 0; n < numbers.length; n++) {
                                if (sub[1].contains(letters[n])) {
                                    sub[1] = numbers[n];
                                }

                            }

                            otherNum = equation.substring(equation.indexOf(input[k]) + 1);

                            for (int n = 0; n < numbers.length; n++) {
                                if (otherNum.contains(letters[n])) {
                                    otherNum = numbers[n];
                                }

                            }
                            answer = Double.valueOf(sub[0]) - Double.valueOf(sub[1]) + Double.valueOf(otherNum);

                            numAnswer = String.valueOf((int)answer); 
                            char[] letterAns = numAnswer.toCharArray();
                            numAnswer = ""; 
                            
                            for (int u = 0; u < letterAns.length; u++) {
                                for (int c = 0; c < numbers.length; c++) {
                                    if (String.valueOf(letterAns[u]).contains(numbers[c])) {
                                        numAnswer += letters[c]; 
                                    }
                                }
                            }
                            
                            System.out.println(numAnswer);
                            last6 = true;
                            break;
                        } else if (input[k] == '/') { //same logic as before 
                            sub[counter6 + 1] = equation.substring(equation.indexOf("-") + 1, equation.indexOf(input[k]));

                            for (int n = 0; n < numbers.length; n++) {
                                if (sub[0].contains(letters[n])) {
                                    sub[0] = numbers[n];
                                }

                            }

                            for (int n = 0; n < numbers.length; n++) {
                                if (sub[1].contains(letters[n])) {
                                    sub[1] = numbers[n];
                                }

                            }

                            otherNum = equation.substring(equation.indexOf(input[k]) + 1);

                            for (int n = 0; n < numbers.length; n++) {
                                if (otherNum.contains(letters[n])) {
                                    otherNum = numbers[n];
                                }

                            }
                            answer = Double.valueOf(otherNum) / Double.valueOf(sub[1]) - Double.valueOf(sub[0]);

                            numAnswer = String.valueOf((int)answer); 
                            char[] letterAns = numAnswer.toCharArray();
                            numAnswer = ""; 
                            
                            for (int u = 0; u < letterAns.length; u++) {
                                for (int c = 0; c < numbers.length; c++) {
                                    if (String.valueOf(letterAns[u]).contains(numbers[c])) {
                                        numAnswer += letters[c]; 
                                    }
                                }
                            }
                            
                            System.out.println(numAnswer);
                            last6 = true;
                            break;
                        }
                    }

                    //check for double occurances (same logic) 
                    int checker = 0;
                    for (int l = 0; l < equation.length(); l++) {
                        if (input[l] == '-') {
                            checker++;
                        }
                    }

                    if (last6 == false && check6 == true && checker > 1) { //same logic 
                        sub[counter6 + 1] = equation.substring(equation.indexOf("-") + 1, secondIndex4);
                        check6 = false;

                    } else if (last6 == false && check6 == false && checker > 1) { //same logic 
                        sub[counter6 + 1] = equation.substring(secondIndex4 + 1);

                        for (int n = 0; n < numbers.length; n++) {
                            if (sub[0].contains(letters[n])) {
                                sub[0] = numbers[n];
                            }

                        }

                        for (int n = 0; n < numbers.length; n++) {
                            if (sub[1].contains(letters[n])) {
                                sub[1] = numbers[n];
                            }

                        }

                        for (int n = 0; n < numbers.length; n++) {
                            if (sub[2].contains(letters[n])) {
                                sub[2] = numbers[n];
                            }

                        }
                        answer = Double.valueOf(sub[0]) - Double.valueOf(sub[1]) - Double.valueOf(sub[2]);

                        numAnswer = String.valueOf((int)answer); 
                            char[] letterAns = numAnswer.toCharArray();
                            numAnswer = ""; 
                            
                            for (int u = 0; u < letterAns.length; u++) {
                                for (int c = 0; c < numbers.length; c++) {
                                    if (String.valueOf(letterAns[u]).contains(numbers[c])) {
                                        numAnswer += letters[c]; 
                                    }
                                }
                            }
                            
                            System.out.println(numAnswer);
                    } else if (last6 == false) { //same logic 
                        sub[counter6 + 1] = equation.substring(equation.indexOf("-") + 1);

                        for (int n = 0; n < numbers.length; n++) {
                            if (sub[0].contains(letters[n])) {
                                sub[0] = numbers[n];
                            }

                        }

                        for (int n = 0; n < numbers.length; n++) {
                            if (sub[1].contains(letters[n])) {
                                sub[1] = numbers[n];
                            }

                        }

                        answer = Double.valueOf(sub[0]) - Double.valueOf(sub[1]);

                        numAnswer = String.valueOf((int)answer); 
                            char[] letterAns = numAnswer.toCharArray();
                            numAnswer = ""; 
                            
                            for (int u = 0; u < letterAns.length; u++) {
                                for (int c = 0; c < numbers.length; c++) {
                                    if (String.valueOf(letterAns[u]).contains(numbers[c])) {
                                        numAnswer += letters[c]; 
                                    }
                                }
                            }
                            
                            System.out.println(numAnswer);
                    }
                    counter6++;

                }

            }
        }
    }

}