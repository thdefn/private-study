package com.haden.prjforstd.builder;


public class NutritionFacts {
    private final int servingSize; //필수
    private final int servings; //필수
    private final int calories;
    private final int fat;
    private final int solium;
    private final int carbonhydrate;
    public static class Builder{
        private final int servingSize;
        private final int servings;
        private int calories = 0;
        private int fat = 0;
        private int solium = 0;
        private int carbonhydrate = 0;


        //필수 요소에 대해 Builder 생성자를 호출함
        //Builder에 필수 요소를 주입받음
        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        // 빌더 체인을 통해 선택 var에 값을 추가함
        public Builder calories(int val){
            calories = val;
            return this;
        }

        public Builder fat(int val){
            fat = val;
            return this;
        }

        public Builder solium(int val){
            solium = val;
            return this;
        }

        public Builder carbonhydrate(int val){
            fat = val;
            return this;
        }

        //마지막으로 build()라는 메서드를 호출해서 상위가 가지고 있는 새로운 객체를 리턴함
        public NutritionFacts build(){
            return new NutritionFacts(this);
        }
    }

    public NutritionFacts(Builder builder) {
        this.calories = builder.calories;
        this.servings = builder.servings;
        this.servingSize = builder.servingSize;
        this.fat = builder.fat;
        this.solium = builder.solium;
        this.carbonhydrate = builder.carbonhydrate;
    }

    //빌더는 코드가 깔끔해지고 명확하게 내가 뭘 하게되는지 알 수 있음

    //변수가 많아질 수록 각 속성의 몇번째에 들어가야하는지 굉장히 혼란스러움
    //네개, 다섯개, 여섯개 생성자 존재 - 7번째 변수 생성했는데 이게 필수인 경우
    // 4- 7까지 생성자 필요한데 네개짜리를 다섯개짜리로 변환해서 에러가 발생하지 않을수도 > 사용자의 인지가 어려움

    //어떤 건 필수인데 어떤 건 선택적인 경우!
    //여러개의 생성자를 두는 방법
    /*public NutritionFacts(int servingSize, int servings, int calories, int fat, int solium, int carbonhydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.solium = solium;
        this.carbonhydrate = carbonhydrate;
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat, int solium){
        this(servingSize, servings, calories, fat, solium, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat){
        this(servingSize, servings, calories, fat, 0);
    }*/


    // 필수 var은 생성자 + setter : Java beans pattern
    // setter은 코드라인이 늘어나는 경향이 있어서 선호하지 않음
    // 객체가 완결성이 있기 전까지는 미완성임
    /*public NutritionFacts(int servingSize, int servings) {
        this.servingSize = servingSize;
        this.servings = servings;
    }

    public void setCalories(int var){
        this.calories = var;
    }*/
}
