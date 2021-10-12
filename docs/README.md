# Language Proposal

# JavaScript Interpreter

## UnicodeLetter
    [aA-zZ]

## UnicodeDigit

## UnicodePunctuation

## Identifiers

### 

## KeyWords

## BooleanLiterals

## ArrayLiteral
    //only needs to be integers
## SpecialFunctions 

## Expressions 

### PrimaryExpression :
    PrimaryExpression :
            Identifier
            Literal
            ArrayLiteral
            ( Expression )

### PostfixExpression :
    PostfixExpression :
            NewExpression
            NewExpression ++
            NewExpression --

### UnaryExpression :
    UnaryExpression :
            PostfixExpression
            delete UnaryExpression
            typeof UnaryExpression
            ++ UnaryExpression
            -- UnaryExpression

### MultiplicativeExpression :
    MultiplicativeExpression :
            UnaryExpression
            MultiplicativeExpression * UnaryExpression
            MultiplicativeExpression / UnaryExpression
            MultiplicativeExpression % UnaryExpression

### AdditiveExpression :
    AdditiveExpression :
            MultiplicativeExpression
            AdditiveExpression + MultiplicativeExpression
            AdditiveExpression - MultiplicativeExpression

### RelationalExpression :
    RelationalExpression :
            AdditiveExpression
            RelationalExpression < AdditiveExpression
            RelationalExpression > AdditiveExpression
            RelationalExpression <= AdditiveExpression
            RelationalExpression >= AdditiveExpression

### EqualityExpression :
    EqualityExpression :
            RelationalExpression
            EqualityExpression == RelationalExpression
            EqualityExpression != RelationalExpression

### LogicalANDExpression :
    LogicalANDExpression :
            BoonleanExpression
            LogicalANDExpression && BoonleanExpression

### LogicalORExpression :
    LogicalORExpression :
            BoonleanExpression
            LogicalORExpression || BoonleanExpression

### AssignmentExpression :
    AssignmentExpression :
            LogicalOrExpression
            PrimaryExpression = AssignmentExpression
            PrimaryExpression AssignmentOperator AssignmentExpression

### AssignmentOperator :
    AssignmentOperator : one of
            +=
            -=

### Expression :
    Expression :
            AssignmentExpression
            Expression , AssignmentExpression

## Statements

### Statement :
    Statement :
            Block
            VariableStatement
            EmptyStatement
            ExpressionStatement
            IfStatement
            IterationStatement

### Block :
    Block :
        { StatementList }

### StatementList :
    StatementList :
            Statement
            StatementList Statement

### VariableStatement :
The key word var is used her for delacring a new vaiable. This required in both QuickSort and Quadratic.
    VariableStatement :
            var VariableDeclaration ;

### VariableDeclaration :
    VariableDeclaration :
            AssignmentExpression

### ExpressionStatement :
    ExpressionStatement :
            Expression ;

### IfStatement :
If statements can be done with the if statement and an if else block can be made with the nearest else to an if. QuickSort and Quadratic need this.
    IfStatement :
            if ( Expression ) Statement else Statement
            if ( Expression ) Statement

### IterationStatement :
Iteration can be done with the key words while or for. The QuickSort functionality requires these.
    IterationStatement :
            while ( Expression ) Statement
            for ( Expression ; Expression ; Expression ) Statement
