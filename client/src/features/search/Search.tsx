import React, {useState} from 'react';
import {useDispatch, useSelector} from 'react-redux';
import {searchResult, sendSearchRequest,} from './searchCity';
import styles from './search.module.css';

export function Search() {
    const cities = useSelector(searchResult);
    console.log(`cities ${JSON.stringify(cities)}`)
    const dispatch = useDispatch();
    const [searchText, setSearchText] = useState('');

    return (
        <div>
            <div className={styles.row}>
                <p> Search</p>
                <input
                    className={styles.textbox}
                    aria-label="Search City"
                    value={searchText}
                    onChange={e => setSearchText(e.target.value)}
                />
                <button
                    className={styles.asyncButton}
                    onClick={() => dispatch(sendSearchRequest(searchText))}
                >
                    Search
                </button>
            </div>
            <div>
                {
                    cities.map(c =>
                        <div>{c['name']}</div>
                    )
                }
            </div>
        </div>
    );
}
