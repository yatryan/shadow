; shadow.standard@Array

%boolean = type i1
%byte = type i8
%ubyte = type i8
%short = type i16
%ushort = type i16
%int = type i32
%uint = type i32
%code = type i32
%long = type i64
%ulong = type i64
%float = type float
%double = type double

declare noalias i8* @malloc(i64)
declare noalias i8* @calloc(i64, i64)

%"shadow.standard@Class$methods" = type { %"shadow.standard@Class"* (%"shadow.standard@Class"*)*, %"shadow.standard@String"* (%"shadow.standard@Class"*)*, %"shadow.standard@String"* (%"shadow.standard@Class"*)*, %"shadow.standard@Class"* (%"shadow.standard@Class"*)* }
@"shadow.standard@Class$methods" = external constant %"shadow.standard@Class$methods"
%"shadow.standard@Class" = type { %"shadow.standard@Class$methods"*, %"shadow.standard@String"*, %"shadow.standard@Class"* }
declare %"shadow.standard@Class"* @"shadow.standard@Class$$getSuperClass"(%"shadow.standard@Class"*)
declare %"shadow.standard@String"* @"shadow.standard@Class$$getClassName"(%"shadow.standard@Class"*)
declare %"shadow.standard@String"* @"shadow.standard@Class$$toString"(%"shadow.standard@Class"*)
declare void @"shadow.standard@Class$$constructor"(%"shadow.standard@Class"*)

%"shadow.standard@Object$methods" = type { %"shadow.standard@Class"* (%"shadow.standard@Object"*)*, %"shadow.standard@String"* (%"shadow.standard@Object"*)* }
@"shadow.standard@Object$methods" = external constant %"shadow.standard@Object$methods"
%"shadow.standard@Object" = type { %"shadow.standard@Object$methods"* }
declare %"shadow.standard@Class"* @"shadow.standard@Object$$getClass"(%"shadow.standard@Object"*)
declare %"shadow.standard@String"* @"shadow.standard@Object$$toString"(%"shadow.standard@Object"*)
declare void @"shadow.standard@Object$$constructor"(%"shadow.standard@Object"*)

%"shadow.standard@String$methods" = type { %"shadow.standard@Class"* (%"shadow.standard@String"*)*, %"shadow.standard@String"* (%"shadow.standard@String"*)* }
@"shadow.standard@String$methods" = external constant %"shadow.standard@String$methods"
%"shadow.standard@String" = type { %"shadow.standard@String$methods"*, { %ubyte*, [1 x %long] } }
declare %"shadow.standard@String"* @"shadow.standard@String$$toString"(%"shadow.standard@String"*)
declare void @"shadow.standard@String$$constructor"(%"shadow.standard@String"*)

%"shadow.standard@Array$methods" = type { %"shadow.standard@Class"* (%"shadow.standard@Array"*)*, %"shadow.standard@String"* (%"shadow.standard@Object"*)*, %long (%"shadow.standard@Array"*)*, %long (%"shadow.standard@Array"*)*, %long (%"shadow.standard@Array"*, %long)*, { %long*, [1 x %long] } (%"shadow.standard@Array"*)* }
@"shadow.standard@Array$methods" = constant %"shadow.standard@Array$methods" { %"shadow.standard@Class"* (%"shadow.standard@Array"*)* @"shadow.standard@Array$$getClass", %"shadow.standard@String"* (%"shadow.standard@Object"*)* @"shadow.standard@Object$$toString", %long (%"shadow.standard@Array"*)* @"shadow.standard@Array$$getDimensions", %long (%"shadow.standard@Array"*)* @"shadow.standard@Array$$getLength", %long (%"shadow.standard@Array"*, %long)* @"shadow.standard@Array$$getLength$long", { %long*, [1 x %long] } (%"shadow.standard@Array"*)* @"shadow.standard@Array$$getLengths" }
%"shadow.standard@Array" = type { %"shadow.standard@Array$methods"*, %long, { %long*, [1 x %long] } }

@"shadow.standard@Class$class" = external constant %"shadow.standard@Class"
@"shadow.standard@Object$class" = external constant %"shadow.standard@Class"
@"shadow.standard@String$class" = external constant %"shadow.standard@Class"
@"shadow.standard@Array$class" = constant %"shadow.standard@Class" { %"shadow.standard@Class$methods"* @"shadow.standard@Class$methods", %"shadow.standard@String"* @.str0, %"shadow.standard@Class"* @"shadow.standard@Object$class" }

define %"shadow.standard@Class"* @"shadow.standard@Array$$getClass"(%"shadow.standard@Array"*) {
    ret %"shadow.standard@Class"* @"shadow.standard@Array$class"
}

define { %long*, [1 x %long] } @"shadow.standard@Array$$getLengths"(%"shadow.standard@Array"*) {
    %this = alloca %"shadow.standard@Array"*
    store %"shadow.standard@Array"* %0, %"shadow.standard@Array"** %this
    %2 = load %"shadow.standard@Array"** %this
    %3 = getelementptr inbounds %"shadow.standard@Array"* %2, i32 0, i32 2
    %4 = load { %long*, [1 x %long] }* %3
    ret { %long*, [1 x %long] } %4
}
define %long @"shadow.standard@Array$$getDimensions"(%"shadow.standard@Array"*) {
    %this = alloca %"shadow.standard@Array"*
    store %"shadow.standard@Array"* %0, %"shadow.standard@Array"** %this
    %2 = load %"shadow.standard@Array"** %this
    %3 = getelementptr inbounds %"shadow.standard@Array"* %2, i32 0, i32 2
    %4 = sext %int 0 to %long
    %5 = load { %long*, [1 x %long] }* %3
    %6 = call i8* @malloc(i64 ptrtoint (%"shadow.standard@Array"* getelementptr(%"shadow.standard@Array"* null, i32 1) to i64))
    %7 = bitcast i8* %6 to %"shadow.standard@Array"*
    %8 = extractvalue { %long*, [1 x %long] } %5, 0
    %9 = ptrtoint %long* %8 to %long
    %10 = extractvalue { %long*, [1 x %long] } %5, 1
    %11 = call i8* @malloc(i64 ptrtoint ([1 x %long]* getelementptr([1 x %long]* null, i32 1) to i64))
    %12 = bitcast i8* %11 to [1 x %long]*
    store [1 x %long] %10, [1 x %long]* %12
    %13 = getelementptr [1 x %long]* %12, i32 0, i32 0
    %14 = insertvalue { %long*, [1 x %long] } { %long* null, [1 x %long] [%long 1] }, %long* %13, 0
    call void @"shadow.standard@Array$$constructor$long$long[]"(%"shadow.standard@Array"* %7, %long %9, { %long*, [1 x %long] } %14)
    %15 = getelementptr %"shadow.standard@Array"* %7, i32 0, i32 0
    %16 = load %"shadow.standard@Array$methods"** %15
    %17 = getelementptr %"shadow.standard@Array$methods"* %16, i32 0, i32 4
    %18 = load %long (%"shadow.standard@Array"*, %long)** %17
    %19 = call %long %18(%"shadow.standard@Array"* %7, %long %4)
    ret %long %19
}
define %long @"shadow.standard@Array$$getLength"(%"shadow.standard@Array"*) {
    %this = alloca %"shadow.standard@Array"*
    %length = alloca %long
    %i = alloca %long
    store %"shadow.standard@Array"* %0, %"shadow.standard@Array"** %this
    %2 = sext %int 1 to %long
    store %long %2, %long* %length
    %3 = sext %int 0 to %long
    store %long %3, %long* %i
    br label %.label1
.label0:
    %4 = load %long* %i
    %5 = load %"shadow.standard@Array"** %this
    %6 = getelementptr %"shadow.standard@Array"* %5, i32 0, i32 0
    %7 = load %"shadow.standard@Array$methods"** %6
    %8 = getelementptr %"shadow.standard@Array$methods"* %7, i32 0, i32 4
    %9 = load %long (%"shadow.standard@Array"*, %long)** %8
    %10 = call %long %9(%"shadow.standard@Array"* %5, %long %4)
    %11 = load %long* %length
    %12 = mul %long %11, %10
    store %long %12, %long* %length
    %13 = load %long* %i
    %14 = sext %int 1 to %long
    %15 = add %long %13, %14
    store %long %15, %long* %i
    br label %.label1
.label1:
    %16 = load %"shadow.standard@Array"** %this
    %17 = getelementptr %"shadow.standard@Array"* %16, i32 0, i32 0
    %18 = load %"shadow.standard@Array$methods"** %17
    %19 = getelementptr %"shadow.standard@Array$methods"* %18, i32 0, i32 2
    %20 = load %long (%"shadow.standard@Array"*)** %19
    %21 = call %long %20(%"shadow.standard@Array"* %16)
    %22 = load %long* %i
    %23 = icmp slt %long %22, %21
    br %boolean %23, label %.label0, label %.label2
.label2:
    %24 = load %long* %length
    ret %long %24
}
define %long @"shadow.standard@Array$$getLength$long"(%"shadow.standard@Array"*, %long) {
    %this = alloca %"shadow.standard@Array"*
    %index = alloca %long
    store %"shadow.standard@Array"* %0, %"shadow.standard@Array"** %this
    store %long %1, %long* %index
    %3 = load %"shadow.standard@Array"** %this
    %4 = getelementptr inbounds %"shadow.standard@Array"* %3, i32 0, i32 2
    %5 = load { %long*, [1 x %long] }* %4
    %6 = load %long* %index
    %7 = extractvalue { %long*, [1 x %long] } %5, 0
    %8 = getelementptr %long* %7, %long %6
    %9 = load %long* %8
    ret %long %9
}
define void @"shadow.standard@Array$$constructor$long$long[]"(%"shadow.standard@Array"*, %long, { %long*, [1 x %long] }) {
    %this = alloca %"shadow.standard@Array"*
    %data = alloca %long
    %lengths = alloca { %long*, [1 x %long] }
    store %"shadow.standard@Array"* %0, %"shadow.standard@Array"** %this
    store %long %1, %long* %data
    store { %long*, [1 x %long] } %2, { %long*, [1 x %long] }* %lengths
    %4 = load %"shadow.standard@Array"** %this
    %5 = getelementptr %"shadow.standard@Array"* %4, i32 0, i32 0
    store %"shadow.standard@Array$methods"* @"shadow.standard@Array$methods", %"shadow.standard@Array$methods"** %5
    %6 = load %"shadow.standard@Array"** %this
    %7 = getelementptr inbounds %"shadow.standard@Array"* %6, i32 0, i32 2
    %8 = sext %int 0 to %long
    %9 = call noalias i8* @calloc(i64 %8, i64 ptrtoint (%long* getelementptr(%long* null, i32 1) to i64))
    %10 = bitcast i8* %9 to %long*
    %11 = insertvalue { %long*, [1 x %long] } undef, %long* %10, 0
    %12 = insertvalue { %long*, [1 x %long] } %11, %long %8, 1, 0
    store { %long*, [1 x %long] } %12, { %long*, [1 x %long] }* %7
    %13 = load %"shadow.standard@Array"** %this
    %14 = getelementptr inbounds %"shadow.standard@Array"* %13, i32 0, i32 1
    %15 = sext %int 0 to %long
    store %long %15, %long* %14
    %16 = load %"shadow.standard@Array"** %this
    %17 = getelementptr inbounds %"shadow.standard@Array"* %16, i32 0, i32 1
    %18 = load %long* %data
    store %long %18, %long* %17
    %19 = load %"shadow.standard@Array"** %this
    %20 = getelementptr inbounds %"shadow.standard@Array"* %19, i32 0, i32 2
    %21 = load { %long*, [1 x %long] }* %lengths
    store { %long*, [1 x %long] } %21, { %long*, [1 x %long] }* %20
    ret void
}

@.array0 = private unnamed_addr constant [21 x %ubyte] c"shadow.standard@Array"
@.str0 = private unnamed_addr constant %"shadow.standard@String" { %"shadow.standard@String$methods"* @"shadow.standard@String$methods", { %ubyte*, [1 x %long] } { %ubyte* getelementptr inbounds ([21 x %ubyte]* @.array0, i32 0, i32 0), [1 x %long] [%long 21] } }
