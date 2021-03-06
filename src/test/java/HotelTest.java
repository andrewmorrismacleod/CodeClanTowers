import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class HotelTest {

    private Hotel hotel;
    private Bedroom bedroom1;
    private Bedroom bedroom2;
    private Bedroom bedroom3;
    private DiningRoom dining;
    private Conference conference1;
    private Conference conference2;
    private Guest guest1;
    private Guest guest2;
    private Guest guest3;
    private Guest guest4;
    private Guest guest5;

    private ArrayList<Bedroom> bedrooms;
    private ArrayList<DiningRoom> dinings;
    private ArrayList<Conference> conferences;
    private ArrayList<Guest> guests;


    @Before
    public void before(){
        bedroom1 = new Bedroom(1, 4, "Double");
        bedroom2 = new Bedroom(2, 1, "Single");
        bedroom3 = new Bedroom(3, 2, "Twin");

        conference1 = new Conference("MacLaren Suite", 40);
        conference2 = new Conference("Renault Suite", 20);

        dining = new DiningRoom(60, "Mess Hall");

        bedrooms = new ArrayList<>();
        dinings = new ArrayList<>();
        conferences = new ArrayList<>();

        bedrooms.add(bedroom1);
        bedrooms.add(bedroom2);
        bedrooms.add(bedroom3);

        conferences.add(conference1);
        conferences.add(conference2);

        dinings.add(dining);

        hotel = new Hotel(bedrooms, dinings, conferences);

        guest1 = new Guest();
        guest2 = new Guest();
        guest3 = new Guest();
        guest4 = new Guest();
        guest5 = new Guest();

        guests = new ArrayList<>();
        guests.add(guest1);
        guests.add(guest2);
        guests.add(guest3);
        guests.add(guest4);

    }

    @Test
    public void hotelHasBedrooms(){
        assertEquals(3,hotel.getNumberOfVacantBedrooms());
    }

    @Test
    public void hotelHasConferenceRooms(){
        assertEquals(2, hotel.getNumberOfConferenceRooms());
    }

    @Test
    public void hotelHasDiningRooms(){
        assertEquals(1, hotel.getNumberOfDiningRooms());
    }

//    @Test
//    public void hotelCanCheckInGuests(){
//        hotel.checkInGuest(guest1);
//        assertEquals(1,hotel.getVacantBedrooms().get(0).getNumberOfGuests());
//    }

    @Test
    public void hotelTotalNumberOfRooms(){
        assertEquals(3, hotel.getTotalNumberOfRooms());
    }

    @Test
    public void hotelCanTakeBooking(){
        Booking booking = hotel.bookRoom(2, guests);
        assertEquals(1, hotel.getNumberOfbookings());
        assertEquals(2, hotel.getNumberOfVacantBedrooms());
        assertEquals(2, booking.getStayLength());
    }

    @Test
    public void hotelCanAssignRate(){
        hotel.giveRoomsRates();
        assertEquals(100, hotel.getVacantBedrooms().get(0).getRate());
    }

    @Test
    public void hotelHasRoomWithCapactiy__true(){
        hotel.bookRoom(3, guests);
        assertEquals(1, hotel.getNumberOfbookings());
    }

    @Test
    public void hotelHasRoomWithCapactiy__false(){
        guests.add(guest5);
        Booking booking = hotel.bookRoom(3, guests);
        assertEquals(0, hotel.getNumberOfbookings());
        assertEquals(null, booking);
    }

}
