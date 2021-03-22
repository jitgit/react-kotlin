import {createSlice, PayloadAction} from '@reduxjs/toolkit';
import {AppThunk, RootState} from '../../app/store';

interface SearchState {
    searchText: '';
    result: [];
}

const initialState: SearchState = {
    searchText: '',
    result: []
};

export const searchCity = createSlice({
    name: 'search',
    initialState,
    reducers: {
        updateSearchResult: (state, action: PayloadAction<any>) => {
            console.log(`${action.payload}`)
            state.result = action.payload;
        },
    }
});

export const {updateSearchResult} = searchCity.actions;

export const sendSearchRequest = (searchText: string): AppThunk => dispatch => {
    fetch(`api/search/${searchText}`)
        .then(res => res.json())
        .then(r =>
            dispatch(updateSearchResult(r))
        )
};

export const searchResult = (state: RootState) => state.search.result;

export default searchCity.reducer;
