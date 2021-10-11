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

## SpecialFunctions 

## Expressions 

### PrimaryExpression :
    Identifier
    Literal
    ArrayLiteral
    ( Expression )

### PostfixExpression :
    NewExpression
    NewExpression [no LineTerminator here] ++
    NewExpression [no LineTerminator here] --

### UnaryExpression :
    PostfixExpression
    delete UnaryExpression
    typeof UnaryExpression
    ++ UnaryExpression
    -- UnaryExpression

### MultiplicativeExpression :
    UnaryExpression
    MultiplicativeExpression * UnaryExpression
    MultiplicativeExpression / UnaryExpression
    MultiplicativeExpression % UnaryExpression

### AdditiveExpression :
    MultiplicativeExpression
    AdditiveExpression + MultiplicativeExpression
    AdditiveExpression - MultiplicativeExpression

### RelationalExpression :
    AdditiveExpression
    RelationalExpression < AdditiveExpression
    RelationalExpression > AdditiveExpression
    RelationalExpression <= AdditiveExpression
    RelationalExpression >= AdditiveExpression

### EqualityExpression :
    RelationalExpression
    EqualityExpression == RelationalExpression
    EqualityExpression != RelationalExpression

### LogicalANDExpression :
    BoonleanExpression
    LogicalANDExpression && BoonleanExpression

### LogicalORExpression :
    BoonleanExpression
    LogicalORExpression || BoonleanExpression

### AssignmentExpression :
    ConditionalExpression
    LeftHandSideExpression = AssignmentExpression
    LeftHandSideExpression AssignmentOperator AssignmentExpression

### AssignmentOperator : one of
    +=
    -=

### Expression :
    AssignmentExpression
    Expression , AssignmentExpression

## Statements

### Statement :
    Block
    VariableStatement
    EmptyStatement
    ExpressionStatement
    IfStatement
    IterationStatement
