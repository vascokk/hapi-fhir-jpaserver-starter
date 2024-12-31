package io.rivux.fhir;

import ca.uhn.fhir.interceptor.api.Hook;
import ca.uhn.fhir.interceptor.api.Interceptor;
import ca.uhn.fhir.interceptor.api.Pointcut;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.hl7.fhir.r4.model.Account;
import org.springframework.stereotype.Component;

@Interceptor
@Component
public class RestProxyClientInterceptor
{
    @Hook(Pointcut.STORAGE_PRECOMMIT_RESOURCE_CREATED)
    public void resourceCreated(IBaseResource newResource)
    {
        System.out.println("RestProxyClientInterceptor.resourceCreated");
        System.out.println("meta :" + newResource.getMeta());
        System.out.println("id :" + newResource.getIdElement());
        System.out.println("fhir type :" + newResource.fhirType());
        System.out.println("to string :" + newResource.toString());
        System.out.println("=============================================");
//        hapi-fhir-jpaserver-start  | RestProxyClientInterceptor.resourceCreated
//        hapi-fhir-jpaserver-start  | meta :org.hl7.fhir.r4.model.Meta@e89766d
//        hapi-fhir-jpaserver-start  | id :Account/5/_history/1
//        hapi-fhir-jpaserver-start  | fhir type :Account
//        hapi-fhir-jpaserver-start  | to string :org.hl7.fhir.r4.model.Account@3225956b
//        hapi-fhir-jpaserver-start  | =============================================
        System.out.println("to string :" + newResource.toString());
//        FhirContext ctx = FhirContext.forR5();
        Account acc = (Account)newResource;
        System.out.println("Account to string: " + acc.toString());
        System.out.println("Account description: " + acc.getDescription());
        System.out.println("Account status: " + acc.getStatus());
        System.out.println("=============================================");
//        hapi-fhir-jpaserver-start  | to string :org.hl7.fhir.r4.model.Account@5f081bbc
//        hapi-fhir-jpaserver-start  | Account to string: org.hl7.fhir.r4.model.Account@5f081bbc
//        hapi-fhir-jpaserver-start  | Account description: Hospital charges !!!!!!!!!!!
//        hapi-fhir-jpaserver-start  | Account status: ACTIVE
//        hapi-fhir-jpaserver-start  | =============================================

    }
}
// example Account payload
/*
{
    "resourceType" : "Account",
    "id" : "example 9",
    "text" : {
      "status" : "generated",
      "div" : "<div xmlns=\"http://www.w3.org/1999/xhtml\">HACC Funded Billing for Peter James Chalmers</div>"
    },
    "identifier" : [{
      "system" : "1b798d6e-02e6-4614-805c-16e0a30694a8",
      "value" : "87654321"
    }],
    "status" : "active",
    "type" : {
      "coding" : [{
        "system" : "http://terminology.hl7.org/CodeSystem/v3-ActCode",
        "code" : "PBILLACCT",
        "display" : "patient billing account"
      }],
      "text" : "patient"
    },
    "name" : "HACC Funded Billing for Peter James Chalmers",
    "description" : "Hospital charges !!!!!!!!!!!"
  }

 */