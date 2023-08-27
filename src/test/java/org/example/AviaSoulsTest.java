package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {

    AviaSouls fly = new AviaSouls();

    Ticket ticket1 = new Ticket("Пермь", "Москва", 6_000, 8, 10);
    Ticket ticket2 = new Ticket("Москва", "Пермь", 6_500, 16, 18);
    Ticket ticket3 = new Ticket("Пермь", "Санкт-Петербург", 5_000, 9, 13);
    Ticket ticket4 = new Ticket("Санкт-Петербург", "Пермь", 4_000, 16, 17);
    Ticket ticket5 = new Ticket("Пермь", "Новосибирск", 6_000, 8, 12);
    Ticket ticket6 = new Ticket("Пермь", "Сочи", 9_200, 8, 12);
    Ticket ticket7 = new Ticket("Сочи", "Москва", 8_500, 19, 20);
    Ticket ticket8 = new Ticket("Пермь", "Сочи", 10_000, 18, 20);

    @Test
    public void shouldSearchTickets() {

        fly.add(ticket1);
        fly.add(ticket2);
        fly.add(ticket3);
        fly.add(ticket4);
        fly.add(ticket5);
        fly.add(ticket6);
        fly.add(ticket7);
        fly.add(ticket8);

        Assertions.assertArrayEquals(new Ticket[]{ticket6, ticket8}, fly.search("Пермь", "Сочи"));
    }

    @Test
    public void shouldSearchOneTicket() {

        fly.add(ticket1);
        fly.add(ticket2);
        fly.add(ticket3);
        fly.add(ticket4);
        fly.add(ticket5);
        fly.add(ticket6);
        fly.add(ticket7);
        fly.add(ticket8);

        Assertions.assertArrayEquals(new Ticket[]{ticket2}, fly.search("Москва", "Пермь"));
    }

    @Test
    public void shouldNotSearchTickets() {

        fly.add(ticket1);
        fly.add(ticket2);
        fly.add(ticket3);
        fly.add(ticket4);
        fly.add(ticket5);
        fly.add(ticket6);
        fly.add(ticket7);
        fly.add(ticket8);

        Assertions.assertArrayEquals(new Ticket[0], fly.search("Пермь", "Казань"));
    }

    @Test
    public void shouldSearchTicketsWithComparator() {
        Comparator<Ticket> comparator = new TicketTimeComparator();

        fly.add(ticket1);
        fly.add(ticket2);
        fly.add(ticket3);
        fly.add(ticket4);
        fly.add(ticket5);
        fly.add(ticket6);
        fly.add(ticket7);
        fly.add(ticket8);

        Assertions.assertArrayEquals(new Ticket[]{ticket8, ticket6}, fly.searchAndSortBy("Пермь", "Сочи", comparator));
    }

    @Test
    public void shouldSearchOneTicketWithComparator() {
        Comparator<Ticket> comparator = new TicketTimeComparator();

        fly.add(ticket1);
        fly.add(ticket2);
        fly.add(ticket3);
        fly.add(ticket4);
        fly.add(ticket5);
        fly.add(ticket6);
        fly.add(ticket7);
        fly.add(ticket8);

        Assertions.assertArrayEquals(new Ticket[]{ticket4}, fly.searchAndSortBy("Санкт-Петербург", "Пермь", comparator));
    }

    @Test
    public void shouldNotSearchTicketsWithComparator() {
        Comparator<Ticket> comparator = new TicketTimeComparator();

        fly.add(ticket1);
        fly.add(ticket2);
        fly.add(ticket3);
        fly.add(ticket4);
        fly.add(ticket5);
        fly.add(ticket6);
        fly.add(ticket7);
        fly.add(ticket8);

        Assertions.assertArrayEquals(new Ticket[0], fly.searchAndSortBy("Казань", "Пермь", comparator));
    }
}