package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    protected List<Resume> resumeList = new ArrayList<>();


    @Override
    protected void doSave(Resume r, Object searchKey) {
        resumeList.add(r);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return resumeList.get((Integer) searchKey);
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        resumeList.set((Integer) searchKey, r);
    }

    @Override
    protected void doDelete(Object searchKey) {
        resumeList.remove(((Integer) searchKey).intValue());
    }

    @Override
    public void clear() {
        resumeList.clear();
    }

    @Override
    public int size() {
        return resumeList.size();
    }

    @Override
    public Resume[] getAll() {
        return resumeList.toArray(new Resume[resumeList.size()]);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return searchKey != null;
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < resumeList.size(); i++) {
            if (resumeList.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }
}