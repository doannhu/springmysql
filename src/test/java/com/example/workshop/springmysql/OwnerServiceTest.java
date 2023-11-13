// package com.example.workshop.springmysql;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.mockito.Mockito.when;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.Mock;
// import org.mockito.junit.jupiter.MockitoExtension;

// import com.example.accessingdatamysql.Entity.Owner;
// import com.example.accessingdatamysql.Repository.OwnerRepository;
// import com.example.accessingdatamysql.Service.OwnerService;

// import java.util.ArrayList;
// import java.util.List;

// @ExtendWith(MockitoExtension.class)
// public class OwnerServiceTest {

//     @Mock
//     private OwnerRepository ownerRepository;

//     @Test
//     public void testGetListOwner() {
//         Owner owner = new Owner();
//         owner.setId(1);
//         owner.setName("joerank");
//         owner.setEmail("testemail@test.com");
//         owner.setPassword("pa55w0rD!");
//         owner.setRoles("ROLE_OWNER");
//         List<Owner> listReturnMock = new ArrayList<Owner>();
//         listReturnMock.add(owner);

//         // set up mock OwnerRepository to return mock owner
//         when(ownerRepository.findAll()).thenReturn(listReturnMock);

//         // create OwnerService and call method to test
//         OwnerService ownerService = new OwnerService();
//         List<Owner> listOwnerReturn = ownerService.getAllOwner();

//         assertEquals(listReturnMock, listOwnerReturn);}
// }




