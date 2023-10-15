import React, { Component } from 'react';

class FooterComponent extends Component {

    render() {
        return (
            <div>
                <footer className='footer'>
                    <span className='text'>All Rights Reserved 2023 <a href='https://www.instagram.com/praneeth_rsp/'>@praneethrsp</a></span>
                    <div>
                        <a href='https://linkedin.com/in/rspraneeth'>LinkedIn</a>
                        | 
                        <a href='https://github.com/rspraneeth'>GitHub</a>
                        |
                        <a href='https://leetcode.com/rspraneeth/'>LeetCode</a>
                    </div>
                </footer>
                
            </div>
        );
    }
}

export default FooterComponent;