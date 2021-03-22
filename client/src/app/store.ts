import {Action, configureStore, ThunkAction} from '@reduxjs/toolkit';
import searchReducer from '../features/search/searchCity';

export const store = configureStore({
    reducer: {
        search: searchReducer,
    },
});

export type RootState = ReturnType<typeof store.getState>;
export type AppThunk<ReturnType = void> = ThunkAction<ReturnType,
    RootState,
    unknown,
    Action<string>>;
