package com.example.busyme;

import java.util.ArrayList;

class Member {
    private String mName;
    private boolean mStatus;

    public Member(String name, boolean status) {
        mName = name;
        mStatus = status;
    }

    public String getName() {
        return mName;
    }

    public boolean getStatus() {
        return mStatus;
    }

    private static int lastContactId = 0;

    public static ArrayList<Member> createContactsList(int numContacts) {
        ArrayList<Member> contacts = new ArrayList<Member>();

        for (int i = 1; i <= numContacts; i++) {
            contacts.add(new Member("Person " + ++lastContactId, i <= numContacts / 2));
        }

        return contacts;
    }
}
