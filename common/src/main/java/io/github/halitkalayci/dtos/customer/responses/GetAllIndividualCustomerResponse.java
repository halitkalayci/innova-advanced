package io.github.halitkalayci.dtos.customer.responses;

// Diğer servislerin GetAllIndividualCustomerResponse'ı alırken anonim çalışmasını engellemek
public class GetAllIndividualCustomerResponse {
  private String id;
  private String firstName;
  private String lastName;

  public GetAllIndividualCustomerResponse(String id, String firstName, String lastName) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public GetAllIndividualCustomerResponse() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}