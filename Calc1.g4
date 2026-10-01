grammar Calc1;

root: expr <EOF>;
expr
    : '(' expr ')'            // 括号优先级最高，直接包裹一个完整的 expr
    | expr (MUL | DIV) expr   // 乘除
    | expr (ADD | SUB) expr   // 加减
    | INT                     // 整数
    ;

INT : [0-9]+ ;
ADD : '+' ;
SUB : '-' ;
MUL:'*';
DIV:'/';
LPAREN : '(' ;
RPAREN : ')' ;
WS  : [ \t\r\n]+ -> skip ; 
