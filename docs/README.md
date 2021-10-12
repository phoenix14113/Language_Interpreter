# Language Proposal

## JavaScript Interpreter


The language definition can be found at <https://262.ecma-international.org/5.1/#sec-12.5>. (see bottom of webpage for condensed syntax)

It might be hard to read at time but for some reason the .md was not accepting bolding or itelics.

## Literals
#### Literal
    Literal :
            StringLiteral
            NumericLiteral
            BooleanLiteral

### StringLiteral
#### SourceCharacter :
This just shows that all of our characters are expressed from Unicode
```BNF
    SourceCharacter :
            any Unicode code unit
```
#### StringLiteral :
Used for output to the console and prompting input in all three programs.
```BNF
    StringLiteral :
            " [DoubleStringCharacters] "
            ' [SingleStringCharacters] '
```
#### DoubleStringCharacters:
    DoubleStringCharacters :
            DoubleStringCharacter [DoubleStringCharacters]

#### SingleStringCharacters :   
    SingleStringCharacters :
            SingleStringCharacter [SingleStringCharacters]

#### DoubleStringCharacter :
    DoubleStringCharacter :
            SourceCharacter but not one of " or \ or LineTerminator
            \ EscapeSequence
            LineContinuation

#### SingleStringCharacter :
    SingleStringCharacter :
            SourceCharacter but not one of ' or \ or LineTerminator
            \ EscapeSequence
            LineContinuation

#### LineContinuation :
    LineContinuation :
            \ LineTerminatorSequence

### LexicalGrammar
Defining all the character types so that it is easier to write the BNF's
#### InputElementDiv :
    InputElementDiv :
            WhiteSpace
            LineTerminator
            Comment
            Token

#### InputElementRegExp :
    InputElementRegExp :
            WhiteSpace
            LineTerminator
            Comment
            Token

#### WhiteSpace :
    WhiteSpace :
            <TAB>
            <VT>
            <FF>
            <SP>
            <NBSP>
            <BOM>
            <USP>

#### LineTerminator :
    LineTerminator :
            <LF>
            <CR>
            <LS>
            <PS>

#### LineTerminatorSequence :
    LineTerminatorSequence :
            <LF>
            <CR> [lookahead ∉ <LF> ]
            <LS>
            <PS>
            <CR> <LF>

#### Comment :
This is so we can make our code nice and pretty and readable.
```BNF
    Comment :
            MultiLineComment
            SingleLineComment
```
#### MultiLineComment :
    MultiLineComment :
            /* [MultiLineCommentChars] */

#### MultiLineNotAsteriskChar :
    MultiLineNotAsteriskChar ::
            SourceCharacter but not one of / or *

#### SingleLineComment :
    SingleLineComment ::
            // [SingleLineCommentChars]
#### SingleLineCommentChars :
    SingleLineCommentChars :
            SingleLineCommentChar [SingleLineCommentChars]
#### SingleLineCommentChars :
    SingleLineCommentChars :
            SourceCharacter but not LineTerminator

#### Token :
    Token :
                IdentifierName
                Punctuator
                NumericLiterals
                StringLiteral
#### Identifier :
Used all over the place for creating variables everywhere needed.
```BNF
    Identifier
                IdentifierName but not ReserveWord
```
#### IdentifierName :
    IdentifierName ::
            [a-zA-Z_][a-zA-Z0-9_]*

#### ReservedWord
    ReservedWord :
                KeyWord
                Punctuator
                BooleanLiteral
                NullLiteral


#### KeyWord
    KeyWord : one of  
        else    var     for     while
        this    if      delete  prompt

#### Punctuator :
```BNF
    Punctuator :  
        {	}	(	)	[	]
        .	;	,	<	>	<=
        >=	==	!=	=	+=	-=
        +	-	*	%	++	--
        !	~	&&	||
```
#### EscapeSequence :
    EscapeSequence :
            CharacterEscapeSequence
            0 [lookahead ∉ DecimalDigit]
            UnicodeEscapeSequence
#### CharacterEscapeSequence :
    CharacterEscapeSequence ::
            SingleEscapeCharacter
            NonEscapeCharacter
#### SingleEscapeCharacter :
    SingleEscapeCharacter : one of
            ' " \ b f n r t v
#### NonEscapeCharacter ::
    NonEscapeCharacter :
            SourceCharacter but not one of EscapeCharacter or LineTerminator
### NumericLiteral
this is used for the quadratic program just in case things evaluate to decimal numbers.
```BNF
    NumericLiteral :
        DecimalLiteral
        signedFloat
        signedInteger
```
#### DecimalLiteral :
```BNF
    DecimalLiteral :
            DecimalIntegerLiteral [ . DecimalDigits]
```

#### DecimalIntegerLiteral :
    DecimalIntegerLiteral :
            0
            NonZeroDigit [DecimalDigits]

#### DecimalDigits :
    DecimalDigits :
            DecimalDigit
            DecimalDigits DecimalDigit

#### DecimalDigit :
    DecimalDigit : one of
            [0-9]

#### NonZeroDigit :
    NonZeroDigit : one of
            [1-9]

#### signedInteger :
    signedInteger :
            DecimalDigits
            - DecimalDigits

#### signedFloat :
    signedFloat :
            DecimalLiteral
            - DecimalLiteral
### Booleans

#### NullLiteral
thought this might be useful
```BNF
    NullLiteral :
            null
```
#### BooleanLiteral
Used for cases and while/for loops in Quadratic and QuickSort programs.
```BNF
    BooleanLiteral :
            true
            false
```
### ArrayLiteral
This is for store the integers in to be sorted
```BNF
    ArrayLiteral :
            [[signedInteger]]
            [ElementList]
            [ElementList , [signedInteger]]
```
#### ElementList
    ElementList :
            [signedInteger] AssignmentExpression
            ElementList , [signedInteger] AssignmentExpression

### SpecialFunctions
This is an expression but we aren't sure how it will work yet so we aren't allowing it to be accessed. It is used for collecting user input. Let us know if we even need this
```BNF
    prompt() :
            prompt()
            prompt( StringLiteral )
            Identifier = prompt()
            Identifier = prompt( StringLiteral )
```
This is an expression but we aren't sure how it will work yet so we aren't allowing it to be accessed. Used for printing to the consol
```BNF
    console.log() :
            console.log( PrimaryExpression )
```
### Expressions 

#### PrimaryExpression :
General definition of what kind of expressions we have.
```BNF
    PrimaryExpression :
            Identifier
            Literal
            ArrayLiteral
            ( Expression )
```

#### PostfixExpression :
Just required in QuickSort for for loop iteration.
```BNF
    PostfixExpression :
            NewExpression
            NewExpression ++
            NewExpression --
```

#### UnaryExpression :
not required but could be nice.
```BNF
    UnaryExpression :
            PostfixExpression
            delete UnaryExpression
            typeof UnaryExpression
            ++ UnaryExpression
            -- UnaryExpression
```

#### MultiplicativeExpression :
Required in both Quadratic and QuickSort.
```BNF
    MultiplicativeExpression :
            UnaryExpression
            MultiplicativeExpression * UnaryExpression
            MultiplicativeExpression / UnaryExpression
```

#### AdditiveExpression :
Required in both Quadratic and QuickSort.
```BNF
    AdditiveExpression :
            MultiplicativeExpression
            AdditiveExpression + MultiplicativeExpression
            AdditiveExpression - MultiplicativeExpression
```

#### RelationalExpression :
Required in both Quadratic and QuickSort.
```BNF
    RelationalExpression :
            AdditiveExpression
            RelationalExpression < AdditiveExpression
            RelationalExpression > AdditiveExpression
            RelationalExpression <= AdditiveExpression
            RelationalExpression >= AdditiveExpression
```

#### EqualityExpression :
Required in both Quadratic and QuickSort.
```BNF
    EqualityExpression :
            RelationalExpression
            EqualityExpression == RelationalExpression
            EqualityExpression != RelationalExpression
```

#### LogicalANDExpression :
Nothing obvious requires this but we have a sneaking suspicion we might need it for something.
```BNF
    LogicalANDExpression :
            BoonleanExpression
            LogicalANDExpression && BoonleanExpression
```

#### LogicalORExpression :
Nothing obvious requires this but we have a sneaking suspicion we might need it for something.
```BNF
    LogicalORExpression :
            BoonleanExpression
            LogicalORExpression || BoonleanExpression
```

#### AssignmentExpression :
Needed to create variable in both QuickSort and Quadratic.
```BNF
    AssignmentExpression :
            LogicalOrExpression
            PrimaryExpression = AssignmentExpression
            PrimaryExpression AssignmentOperator AssignmentExpression
```

#### AssignmentOperator :
    AssignmentOperator : one of
            +=
            -=

#### Expression :
    Expression :
            AssignmentExpression
            Expression , AssignmentExpression

### Statements

#### Statement :
General declaration of what different kind of statements there are.
```BNF
    Statement :
            Block
            VariableStatement
            EmptyStatement
            ExpressionStatement
            IfStatement
            IterationStatement
```

#### Block :
Needed every time a block is made.
```BNF
    Block :
        { StatementList }
```

#### StatementList :
Needed every time there is more than one line of code.
```BNF
    StatementList :
            Statement
            StatementList Statement
```

#### VariableStatement :
The key word var is used her for delacring a new vaiable. This required in both QuickSort and Quadratic.
```BNF
    VariableStatement :
            var VariableDeclaration ;
```
#### VariableDeclaration :
    VariableDeclaration :
            Identifier [Initialiser]
#### Initialiser :
    VariableDeclaration :
            = AssignmentExpression

#### ExpressionStatement :
    ExpressionStatement :
            Expression ;

#### IfStatement :
If statements can be done with the if statement and an if else block can be made with the nearest else to an if. QuickSort and Quadratic need this.
```BNF
    IfStatement :
            if ( Expression ) Statement else Statement
            if ( Expression ) Statement
```

#### IterationStatement :
Iteration can be done with the key words while or for. The QuickSort functionality requires these.
```BNF
    IterationStatement :
            while ( Expression ) Statement
            for ( Expression ; Expression ; Expression ) Statement
```
