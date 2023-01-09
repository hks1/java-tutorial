package com.hks.design.patterns.factorymethod;

public class GetPlanFactory {

    public Plan getPlan(String planType){
        if (planType == null){
            return null;
        }
        if (planType.equalsIgnoreCase("DOMESTICPLAN")){
            return new DomesticPlan();
        }
        if (planType.equalsIgnoreCase("COMMERCIALPLAN")){
            return new CommercialPlan();
        }
        if (planType.equalsIgnoreCase("INSTITUTIONALPLAN")){
            return new InstitutionalPlan();
        }
        return null;
    }
}
