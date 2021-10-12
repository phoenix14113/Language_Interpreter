# Language Proposal

## JavaScript Interpreter


The language definition can be found at <https://262.ecma-international.org/5.1/#sec-12.5>.

### Identifiers

### KeyWords

## Literal
    Literal :
            StringLiteral
            DecimalLiteral
            BooleanLiterals

### StringLiteral

#### StringLiteral :
    StringLiteral :

### NumericLiterals

#### DecimalLiteral :
    DecimalLiteral :
            DecimalIntegerLiteral . [DecimalDigits]

#### DecimalIntegerLiteral :
    DecimalIntegerLiteral :
            0
            NonZeroDigit [DecimalDigits]

#### DecimalDigits :
    DecimalDigits :
            DecimalDigits
            DecimalDigits DecimalDigit

#### DecimalDigit :
    DecimalDigit : one of
            0 1 2 3 4 5 6 7 8 9

#### NonZeroDigit :
    NonZeroDigit : one of
            1 2 3 4 5 6 7 8 9

#### signedInteger :
    signedInteger :
            DecimalDigits
            - DecimalDigits

#### signedFloat :
    signedFloat :
            DecimalLiteral
            - DecimalLiteral
### Booleans

#### BooleanLiterals
    BooleanLiterals :
            true
            false

### ArrayLiteral
    //only needs to be integers

## 
### SpecialFunctions 

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
            AssignmentExpression

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
