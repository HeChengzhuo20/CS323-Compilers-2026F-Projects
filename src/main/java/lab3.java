import generated.ex1.ex1;

import java.io.IOException;

import org.antlr.v4.parse.GrammarTreeVisitor.channelSpec_return;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

public class lab3 {
    public static void main(String[] args) {
        CharStream charStream = null;
        int ws = 0;
        try {
            charStream = CharStreams.fromFileName("/home/cs323/Desktop/CS323-Compilers-2026F-Projects/src/main/java/testcase/test1.c");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        ex1 lexer =
                new ex1(charStream);

        CommonTokenStream tokens =
                new CommonTokenStream(lexer);

        tokens.fill();

        for (Token token : tokens.getTokens()) {
            // 不输出 EOF
            if (token.getType() == Token.EOF) {
                continue;
            }
            if (token.getChannel() != Token.DEFAULT_CHANNEL) {
                ws++;
                continue; 
            }
            
            String tokenType =
                    lexer.getVocabulary()
                            .getSymbolicName(token.getType());

            System.out.printf(
                    "TokenType: %s, Lexeme: %s%n",
                    tokenType,
                    token.getText()
            );
        }
        System.out.println("ws: " + ws);
    }
}
