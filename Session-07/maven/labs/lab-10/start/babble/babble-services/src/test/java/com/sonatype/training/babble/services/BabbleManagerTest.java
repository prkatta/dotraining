/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sonatype.training.babble.services;

import org.junit.Test;

import com.sonatype.training.babble.domain.Babble;
import com.sonatype.training.babble.domain.Babbler;

import java.util.List;
import org.junit.Before;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 *
 * @author johnsmart
 */
public class BabbleManagerTest {

    BabbleManager manager;

    @Before
    public void setup() {
        manager = BabbleManager.getInstance();
        manager.clear();
    }

    @Test
    public void shouldRegisterNewUserWithUniqueName() throws NameAlreadyExistsException {
        manager.register("joe");
        
        Babbler babbler = manager.findByName("joe");
        assertThat(babbler.getName(), is("joe"));
    }

    @Test(expected=NameAlreadyExistsException.class)
    public void shouldNotRegisterNewUserWithExistingName() throws NameAlreadyExistsException {
        manager.register("jake");
        manager.register("joe");
        assertThat(manager.findByName("joe").getName(), is("joe"));
        assertThat(manager.findByName("jake").getName(), is("jake"));

        manager.register("jake");
    }

    @Test
    public void shouldListAllBabblers() throws NameAlreadyExistsException {
        manager.register("jake");
        manager.register("joe");
        manager.register("jill");

        List<Babbler> babblers = manager.findAll();
        assertThat(babblers.size(), is(3));
        assertThat(babblers.contains(new Babbler("jake")),is(true));
        assertThat(babblers.contains(new Babbler("joe")),is(true));
        assertThat(babblers.contains(new Babbler("jill")),is(true));
    }

    @Test
    public void shoulddListAllBabblersInImmutableList() throws NameAlreadyExistsException {
        manager.register("jake");
        manager.register("joe");
        manager.register("jill");

        List<Babbler> babblers = manager.findAll();
        babblers.add(new Babbler("sneeky"));

        List<Babbler> newBabblers = manager.findAll();
        assertThat(newBabblers.size(), is(3));
        assertThat(newBabblers.contains(new Babbler("jake")),is(true));
        assertThat(newBabblers.contains(new Babbler("joe")),is(true));
        assertThat(newBabblers.contains(new Babbler("jill")),is(true));
        assertThat(newBabblers.contains(new Babbler("sneeky")),is(false));
    }

  }
