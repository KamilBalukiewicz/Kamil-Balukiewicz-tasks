package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TrelloMapperTest {

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    public void shouldMapToBoards() {
        //given
        List<TrelloListDto> list1 = new ArrayList<>();
        list1.add(new TrelloListDto("1", "list1", false));
        List<TrelloBoardDto> trelloBoardsDto = new ArrayList<>();
        trelloBoardsDto.add(new TrelloBoardDto("1","Board 1", list1));
        //when
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloBoardsDto);
        //then
        assertEquals("Board 1", trelloBoards.get(0).getName());
        assertEquals("1", trelloBoards.get(0).getId());
        assertEquals("list1", trelloBoards.get(0).getLists().get(0).getName());
        assertEquals(1, trelloBoards.size());
    }
    @Test
    public void shouldMapToBoardsDto() {
        //given
        List<TrelloList> list1 = new ArrayList<>();
        list1.add(new TrelloList("1", "list1", false));
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("1", "Board 1", list1));
        //when
        List<TrelloBoardDto> trelloBoardsDto = trelloMapper.mapToBoardsDto(trelloBoards);
        //then
        assertEquals("Board 1", trelloBoardsDto.get(0).getName());
        assertEquals("1", trelloBoardsDto.get(0).getId());
        assertEquals("list1", trelloBoardsDto.get(0).getLists().get(0).getName());
        assertEquals(1, trelloBoardsDto.size());
    }
    @Test
    public void shouldMapToList() {
        //given
        List<TrelloListDto> listDto = new ArrayList<>();
        listDto.add(new TrelloListDto("1", "list1", false));
        listDto.add(new TrelloListDto("2","list2", false));
        //when
        List<TrelloList> trelloLists = trelloMapper.mapToList(listDto);
        //then
        assertEquals(2, trelloLists.size());
        assertEquals("1", trelloLists.get(0).getId());
        assertEquals("list2", trelloLists.get(1).getName());
    }
    @Test
    public void shouldMapToListDto() {
        //given
        List<TrelloList> list = new ArrayList<>();
        list.add(new TrelloList("1", "list1", false));
        list.add(new TrelloList("2", "list2", false));
        //when
        List<TrelloListDto> trelloListsDto = trelloMapper.mapToListDto(list);
        //then
        assertEquals(2, trelloListsDto.size());
        assertEquals("list1", trelloListsDto.get(0).getName());
        assertEquals(false, trelloListsDto.get(1).isClosed());
    }
    @Test
    public void shouldMapToCard() {
        //given
        TrelloCardDto trelloCardDto = new TrelloCardDto("test card", "test description",
                "top", "1");
        //when
        TrelloCard theCard = trelloMapper.mapToCard(trelloCardDto);
        //then
        assertEquals("test card", theCard.getName());
        assertEquals("top", theCard.getPos());
    }
    @Test
    public void shouldMapToCardDto() {
        //given
        TrelloCard trelloCard = new TrelloCard("test card", "test description",
                "top", "1");
        //when
        TrelloCardDto theCardDto = trelloMapper.mapToCardDto(trelloCard);
        //then
        assertEquals("test description", theCardDto.getDescription());
        assertEquals("1", theCardDto.getListId());
    }
}
