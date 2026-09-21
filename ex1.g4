lexer grammar ex1;

channels { WHITESPACE}

INT_KW: 'int';
MAIN: 'main';
STRING_KW:'String';
INT : [0-9]+ ;
fragment ESCAPED_QUOTE
    : '\\' '"'
    ;

STRING
    : '"' (ESCAPED_QUOTE | ~["])* '"'
    ;
IDENTIFIER : [a-z|A-Z]+ ;
WS  : [ \t\r\n]+ -> channel(WHITESPACE) ;
