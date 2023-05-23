import java.util.Stack;
import java.util.Scanner;

public class ExpressaoAritmetica{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite uma expressão: ");
        String expressao = input.nextLine();

        if(verificarparametrizacao(expressao)){
            System.out.println("Expressao correta!");
        }else{
            System.out.println("Expressao incorreta!");
        }
    }

        public static boolean verificarparametrizacao(String expressao){
           Stack<Character> pilha = new Stack<>();
           
           for(char caractere : expressao.toCharArray()){
            if(caractere == '(' || caractere == '{' || caractere == '['){
                pilha.push(caractere);
            }else if(caractere == ')' || caractere == '}' || caractere == ']'){
                if(pilha.isEmpty()){
                    return false;
                }

                char topo = pilha.pop();

                if((caractere == ')' && topo != '(') || (caractere == '}' && topo != '{') || (caractere == ']' && topo == '[')){
                    return false;
                }
            }
        }
        return pilha.isEmpty();
    }
}

